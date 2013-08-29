/*
 * MyCocktail Mashup Builder
 * David del Pozo González (dpozog--at--grupogesfor.com)
 * Copyright 2008 - 2011 Informática Gesfor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

(function() {

var EditorAppExt = function(config){
  EditorAppExt.superclass.constructor.call(this,config);
};

Ext.extend(EditorAppExt, afrous.editor.EditorApp, {

  setupLayout: function(){
    EditorAppExt.superclass.setupLayout.call(this);
    this.openMenu.insert(0,new Ext.menu.Item({ text : 'Open',
                                               handler : this.openProcessFromServer,
                                               scope : this }));
    this.saveMenu.insert(0,new Ext.menu.Item({ text : 'Save as',
                                               handler : function(){ this.saveProcessToServer(true) },
                                               scope : this }));
    this.saveMenu.insert(0,new Ext.menu.Item({ text : 'Save',
                                               handler : function(){ this.saveProcessToServer() },
                                               scope : this }));
    this.publishMenuGadget.insert(0,new Ext.menu.Item({ text : 'W3C Widget',
                                                        handler : function(){ this.exportToW3CWidget() },
                                                        cls: 'x-menu-item af-w3c-widget-btn',
                                                        scope : this }));
  }
  ,

  openProcessFromLocal : function() {
    if (!this.openLocalDialog) {
      this.openLocalDialog = new OpenProcessLocalDialog(this);
    }
    this.openLocalDialog.show();
  }
  ,

  openProcessFromServer : function() {
    if (!this.openDialog) {
      this.openDialog = new OpenProcessDialog();
      this.openDialog.setCallback(function(key) {
        if (key) this.loadProcessFromServer(key);
      }, this);
    }
    this.openDialog.show();
  }
  ,

  saveProcessToLocal : function() {
    var processConfig = this.rootProcessPanel.processDef.toConfig();
    if(!this.iframeSaveFile)
    {
      this.iframeSaveFile = document.createElement('iframe');
      document.body.appendChild(this.iframeSaveFile);
    }
    this.iframeSaveFile.src = afrous.config.PROCESS_SAVE_LOC_ULR+'?json='+afrous.url.urlEncode(afrous.lang.toJSON(processConfig));
  }
  ,

  saveProcessToServer : function(copying) {
    if (!this.saveDialog) {
      this.saveDialog = new SaveProcessDialog(this);
    }
    if(!copying && this.processKeyID)
    {
      var processConfig = this.rootProcessPanel.processDef.toConfig();
      var json = afrous.lang.toJSON(processConfig);

      var conn = new Ext.data.Connection();
      conn.request({
        url: afrous.config.PROCESS_SAVE_URL,
        method: 'POST',
        params: {id: this.processKeyID, json: json},
        success: function(responseObject) {
          var data  = responseObject.responseXML;
          var error = data.getElementsByTagName("error");
          if(error.length == 0)
          {
            Ext.Msg.alert('Saved', 'Mashup updated correctly');
          }
          else
          {
            Ext.Msg.alert('Error', error[0].textContent);
          }
        },
        failure: function() {
          Ext.Msg.alert('Status', 'Unable to save mashup at this time. Please try again later.');
        }
      });
    }
    else
    {
      this.saveDialog.show();
    }
  }
  ,
  
  exportToW3CWidget : function() {
    if (!this.exportWidgetDialog) {
      this.exportWidgetDialog = new ExportWidgetDialog(this);
    } 
    this.exportWidgetDialog.show();
  }
});


/**
 * @class OpenProcessDialog
 * @extends AbstractCallbackDialog
 */
var OpenProcessDialog = function() {

  OpenProcessDialog.superclass.constructor.call(this, {
    title : 'Open Process',
    modal : true,
    width : 600,
    height : 380,
    resizable : false,
    shadow : true
  });

  this.addKeyListener(27, this.hide, this);
  this.openBtn = this.addButton('Open', this.handleOpen, this);
  this.closeBtn = this.addButton('Close', this.hide, this);

  this.setup();
}

Ext.extend(OpenProcessDialog, afrous.editor.AbstractCallbackDialog, {

  setup : function() {

    this.ds = new Ext.data.Store({
      proxy: new Ext.data.ScriptTagProxy({
        url: afrous.config.PROCESS_PRIVATE_URL
      }),

      reader: new Ext.data.JsonReader({
         root: 'mashup',
         id: 'id',
         fields : [ 'id', 'name', 'description', 'json']
      }),

      remoteSort: true
    });

    var cm = new Ext.grid.ColumnModel([
      { header: "Name",
        dataIndex: 'name',
        width : 150,
        css: 'white-space:normal;' },
      { header: "Description",
        dataIndex: 'description',
        width : 350 }
    ]);

    this.gridEl = this.body.createChild({ cls : 'af-dlg-grid' });
    // create the editor grid
    this.grid = new Ext.grid.Grid(this.gridEl, {
      ds: this.ds,
      cm: cm,
      selModel: new Ext.grid.RowSelectionModel({singleSelect:true}),
      enableColLock : false,
      loadMask : true
    });

    // render it
    this.grid.render();

    var gridFoot = this.grid.getView().getFooterPanel(true);

    // add a paging toolbar to the grid's footer
    this.paging = new Ext.PagingToolbar(gridFoot, this.ds, {
      pageSize: 10,
      displayInfo: true,
      displayMsg: 'Displaying processes {0} - {1} of {2}',
      emptyMsg: "No processes to display"
    });

    this.grid.on('cellclick', this.handleGridUpdate, this);
    this.ds.on('load', this.handleGridUpdate, this);

    function renderDate(value) {
      var d = new Date(value);
      var yy = d.getFullYear();
      var mm = d.getMonth()+1;
      if (mm<10) mm = '0'+mm;
      var dd = d.getDate();
      if (dd<10) dd = '0'+dd;
      var hh = d.getHours();
      if (hh<10) hh = '0'+hh;
      var mi = d.getMinutes();
      if (mi<10) mi = '0'+mi;
      return [yy,'-',mm,'-',dd,' ',hh,':',mi].join('');
    }
  }
  ,

  show : function() {
    this.ds.load();
    this.paging.updateInfo();
    OpenProcessDialog.superclass.show.call(this);
  }
  ,

  handleGridUpdate : function() {
    if (this.grid.getSelections().length>0) {
      this.openBtn.enable();
    } else {
      this.openBtn.disable();
    }
  }
  ,

  handleOpen : function() {
    var selections = this.grid.getSelections();
    if (selections.length==1) {
      var key = selections[0].data.id;
      this.callback.call(this.scope, key);
      this.hide();
    }
  }

});


var OpenProcessLocalDialog = function(editor) {

  OpenProcessLocalDialog.superclass.constructor.call(this, {
    title : 'Open Process',
    modal : true,
    width : 600,
    height : 380,
    resizable : false,
    shadow : true
  });

  this.editor = editor;

  var html =[
  '<div style="padding: 10px;"><p>Please select a file with a process stored or paste process config here in the text area.</p>',
  '<form id="fileForm" method="POST" enctype="multipart/form-data" action="'+afrous.config.PROCESS_OPEN_URL+'" target="contentFileIframe">',
  '  <input type="file" name="fileInput" id="fileInput" value="" size="38" onchange="afrous.editor.FileChooserEvent.onChangeFileChooser();" />',
  '</form>',
  '<textarea class="ext-mb-textarea" id="textareaFileContent" rows="14" cols="70"> </textarea>',
  '<iframe id="contentFileIframe" name="contentFileIframe" style="display: none;"/>',
  '</div>'].join("\n");

  this.body.dom.innerHTML = html;

  this.addKeyListener(27, this.hide, this);
  this.openBtn = this.addButton('Open', this.submit, this);
  this.closeBtn = this.addButton('Close', this.hide, this);
}

Ext.extend(OpenProcessLocalDialog, afrous.editor.AbstractCallbackDialog, {

  submit : function() {
    var processConfig = afrous.lang.parseJSON(document.getElementById("textareaFileContent").value);
    this.editor.newProcess();
    this.editor.loadProcessConfig(processConfig);
    this.hide();
  }
  ,

  hide: function() {
    if (this.PID) window.clearInterval(this.PID);
    OpenProcessLocalDialog.superclass.hide.call(this);
  }
  ,

  show: function() {
    this.PID = window.setInterval(function(){
      if(afrous.editor.OpenProcessLocalDialog.submit > 0)
      {
        var iframeDoc = document.getElementById("contentFileIframe").contentDocument;
        var text = iframeDoc.getElementById("json").value;
        if(document.getElementById("textareaFileContent").value != text)
        {
          document.getElementById("textareaFileContent").value = text;
          afrous.editor.OpenProcessLocalDialog.submit--;
        }
      }
    }, 100);
    document.getElementById("textareaFileContent").value = "";
    document.getElementById("fileInput").value = "";
    OpenProcessLocalDialog.superclass.show.call(this);
  }
});


/**
 * @class SaveProcessDialog
 * @extends AbstractCallbackDialog
 */
var SaveProcessDialog = function(editor) {

  SaveProcessDialog.superclass.constructor.call(this, {
    title : 'Save Process',
    modal : true,
    width : 320,
    height : 154,
    resizable : false,
    shadow : true
  });

  this.formEl = this.body.createChild({cls : 'af-dlg-form'});
  this.form = new Ext.form.Form({labelWidth : 70});
  this.nameField = new Ext.form.TextField({
    fieldLabel : 'Name',
    name : 'name',
    width : 200
  });
  this.descriptionField = new Ext.form.TextField({
    fieldLabel : 'Description',
    name : 'description',
    width : 200
  });
  this.form.add(this.nameField, this.descriptionField);
  this.form.render(this.formEl);

  this.editor = editor;
  this.addKeyListener(27, this.hide, this);

  this.openBtn = this.addButton('Save', this.submit, this);
  this.closeBtn = this.addButton('Close', this.hide, this);
}

Ext.extend(SaveProcessDialog, afrous.editor.AbstractCallbackDialog, {

  submit : function(){
    var name        = this.nameField.getValue();
    var description = this.descriptionField.getValue();

    if(name == "")
    {
      Ext.Msg.alert('Warning', 'Please complete the "Name" field');
      return;
    }

    var processConfig = this.editor.rootProcessPanel.processDef.toConfig();
    processConfig.name = name;
    var json = afrous.lang.toJSON(processConfig);

    var _this = this;
    var conn = new Ext.data.Connection();
    conn.request({
        url: afrous.config.PROCESS_SAVE_URL,
        method: 'POST',
        params: {name: name, description: description, json: json},
        success: function(responseObject) {
          var data  = responseObject.responseXML;
          var error = data.getElementsByTagName("error");
          if(error.length == 0)
          {
            var ids = data.getElementsByTagName("id");
            if(ids.length > 0)
            {
              var id = ids[0].textContent;
              _this.editor.rootProcessPanel.setProcessName(name);
              _this.editor.setProcessKeyID(id);
              Ext.Msg.alert('Saved', 'Mashup saved correctly');
            }
          }
          else
          {
            Ext.Msg.alert('Error', error[0].textContent);
          }
        },
        failure: function() {
          Ext.Msg.alert('Status', 'Unable to save mashup at this time. Please try again later.');
        }
    });

    this.hide();
  }
  ,

  show : function() {
    this.nameField.reset();
    this.descriptionField.reset();
    SaveProcessDialog.superclass.show.call(this);
  }

});


/**
 * @class SaveProcessDialog
 * @extends AbstractCallbackDialog
 */
var ExportWidgetDialog = function(editor) {

  ExportWidgetDialog.superclass.constructor.call(this, {
    title : 'Export as W3C Widget',
    modal : true,
    width : 330,
    height : 340,
    resizable : false,
    shadow : true
  });

  this.formEl = this.body.createChild({cls : 'af-dlg-form'});
  this.form = new Ext.form.Form({labelWidth : 80});
  this.nameField = new Ext.form.TextField({
    fieldLabel : 'Name',
    name : 'name',
    width : 200
  });
  this.form.add(this.nameField);
  this.descriptionField = new Ext.form.TextField({
    fieldLabel : 'Description',
    name : 'description',
    width : 200
  });
  this.form.add(this.descriptionField);
  this.authorField = new Ext.form.TextField({
    fieldLabel : 'Author',
    name : 'author',
    width : 200
  });
  this.form.add(this.authorField);
  this.authorURLField = new Ext.form.TextField({
    fieldLabel : 'Author URL',
    name : 'authorURL',
    width : 200
  });
  this.form.add(this.authorURLField);
  this.authorEmailField = new Ext.form.TextField({
    fieldLabel : 'Author e-mail',
    name : 'authorEmail',
    width : 200
  });
  this.form.add(this.authorEmailField);
  this.versionField = new Ext.form.TextField({
    fieldLabel : 'Version',
    name : 'version',
    width : 200
  });
  this.form.add(this.versionField);
  this.licenseField = new Ext.form.TextField({
    fieldLabel : 'License',
    name : 'license',
    width : 200
  });
  this.form.add(this.licenseField);
  this.widthField = new Ext.form.TextField({
    fieldLabel : 'Width',
    name : 'width',
    width : 200
  });
  this.form.add(this.widthField);
  this.heightField = new Ext.form.TextField({
    fieldLabel : 'Height',
    name : 'height',
    width : 200
  });
  this.form.add(this.heightField);
  
  this.form.render(this.formEl);

  this.editor = editor;
  this.addKeyListener(27, this.hide, this);

  this.openBtn  = this.addButton('Save',  this.submit, this);
  this.closeBtn = this.addButton('Close', this.hide,   this);
}

Ext.extend(ExportWidgetDialog, afrous.editor.AbstractCallbackDialog, {

  submit : function(){
    var name             = this.nameField       .getValue();
    var description      = this.descriptionField.getValue();
    var author           = this.authorField     .getValue();
    var authorURL        = this.authorURLField  .getValue();
    var authorEmail      = this.authorEmailField.getValue();
    var version          = this.versionField    .getValue();
    var license          = this.licenseField    .getValue();
    var width            = this.widthField      .getValue();
    var height           = this.heightField     .getValue();

    if(name == "")
    {
      Ext.Msg.alert('Warning', 'Please complete the "Name" field');
      return;
    }
    
    if(!this.iframeExportToW3CWidget)
    {
      this.iframeExportToW3CWidget = document.createElement('iframe');
      document.body.appendChild(this.iframeExportToW3CWidget);
    }
    this.iframeExportToW3CWidget.src = afrous.config.EXPORT_TO_W3C_WIDGET+'?page='+afrous.url.urlEncode(this.editor.generateHTML()) +
        '&name='+name+'&description='+description+'&author='+author+'&authorURL='+authorURL+'&authorEmail='+authorEmail+
        '&version='+version+'&license='+license+'&width='+width+'&height='+height;

    this.hide();
  }
  ,

  show : function() {
    this.nameField       .reset();
    this.descriptionField.reset();
    this.authorField     .reset();
    this.authorURLField  .reset();
    this.authorEmailField.reset();
    this.versionField    .reset();
    this.licenseField    .reset();
    this.widthField      .reset();
    this.heightField     .reset();
    ExportWidgetDialog.superclass.show.call(this);
  }

});


var FileChooserEvent = afrous.lang.defineClass({

  initialize : function() {
  }
  ,

  onChangeFileChooser : function() {
    document.getElementById("fileForm").submit();
    afrous.editor.OpenProcessLocalDialog.submit++;
  }
});


afrous.editor.EditorApp = EditorAppExt;

afrous.editor.FileChooserEvent = new FileChooserEvent();
afrous.editor.OpenProcessLocalDialog = {};
afrous.editor.OpenProcessLocalDialog.submit = 0;

afrous.config = afrous.lang.extend({
  EXPORT_TO_W3C_WIDGET : afrous.baseURL+'/mashup/exportToW3CWidget'
}, afrous.config || {});

})();


