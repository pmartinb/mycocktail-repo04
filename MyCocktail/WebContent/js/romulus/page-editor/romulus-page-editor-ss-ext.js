/*
 * MyCocktail Mashup Builder
 * David del Pozo González (dpozog--at--grupogesfor.com)
 * Copyright 2008 - 2010 Informática Gesfor
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

var RomulusPageEditorExt = function(config){
  RomulusPageEditorExt.superclass.constructor.call(this,config);
};

Ext.extend(RomulusPageEditorExt, romulus.pageEditor.RomulusPageEditor, {

  createToolBar: function(el) {
    RomulusPageEditorExt.superclass.createToolBar.call(this, el);
    this.openMenu.insert(0,new Ext.menu.Item({text : 'Open',
                                               handler : this.openPageFromServer,
                                               scope : this}));
    this.saveMenu.insert(0,new Ext.menu.Item({text : 'Save as',
                                               handler : function(){this.savePageToServer(true)},
                                               scope : this}));
    this.saveMenu.insert(0,new Ext.menu.Item({text : 'Save',
                                               handler : function(){this.savePageToServer()},
                                               scope : this}));
  }
  ,

  openPageFromLocal : function() {
    if (!this.openLocalDialog) {
      this.openLocalDialog = new OpenPageLocalDialog(this);
    }
    this.openLocalDialog.show();
  }
  ,

  openPageFromServer : function() {
    if (!this.openPageDialog) {
      this.openPageDialog = new OpenPageDialog();
      this.openPageDialog.setCallback(function(key) {
        if (key) this.loadProcessFromServer(key);
      }, this);
    }
    this.openPageDialog.show();
  }
  ,

  savePageToLocal : function() {
    var json = this.toConfig();
    if(!this.iframeSaveFile)
    {
      this.iframeSaveFile = document.createElement('iframe');
      document.body.appendChild(this.iframeSaveFile);
    }
    this.iframeSaveFile.src = afrous.config.PROCESS_SAVE_LOC_ULR+'?json='+afrous.url.urlEncode(afrous.lang.toJSON(json));
  }
  ,

  savePageToServer : function(copying) {
    if (!this.saveDialog) {
      this.saveDialog = new SavePageDialog(this);
    }
    if(!copying && this.pageKeyID)
    {
      var pageConfig = this.toConfig();
      var json = afrous.lang.toJSON(pageConfig);

      var conn = new Ext.data.Connection();
      conn.request({
        url: romulus.pageEditor.config.PAGE_SAVE_URL,
        method: 'POST',
        params: {id: this.pageKeyID, json: json},
        success: function(responseObject) {
          var data  = responseObject.responseXML;
          var error = data.getElementsByTagName("error");
          if(error.length == 0)
          {
            Ext.Msg.alert('Saved', 'Page updated correctly');
          }
          else
          {
            Ext.Msg.alert('Error', error[0].textContent);
          }
        },
        failure: function() {
          Ext.Msg.alert('Status', 'Unable to save page at this time. Please try again later.');
        }
      });
    }
    else
    {
      this.saveDialog.show();
    }
  }

});


/**
 * @class OpenPageDialog
 */
var OpenPageDialog = function() {

  this.setup();

  OpenPageDialog.superclass.constructor.call(this, {
    title : 'Open Page',
    modal : true,
    width : 600,
    height : 380,
    resizable : false,
    shadow : true,
    closeAction : 'hide',
    keys: [{
      key: 27,
      fn: this.hide,
      scope: this
    }],
    items: [
      this.grid
    ]
  });

  this.openBtn = this.addButton('Open', this.handleOpen, this);
  this.closeBtn = this.addButton('Close', this.hide, this);
}

Ext.extend(OpenPageDialog, Ext.Window, {

  setCallback : function(callback, scope) {
    this.callback = callback;
    this.scope = scope;
  }
  ,

  setup : function() {

    this.ds = new Ext.data.Store({
      proxy: new Ext.data.ScriptTagProxy({
        url: romulus.pageEditor.config.PAGE_PRIVATE_URL
      }),

      reader: new Ext.data.JsonReader({
         root: 'page',
         id: 'id',
         fields : [ 'id', 'name', 'description', 'json']
      }),

      remoteSort: true
    });

    var cm = new Ext.grid.ColumnModel([
      {header: "Name",
        dataIndex: 'name',
        width : 150,
        css: 'white-space:normal;'},
      {header: "Description",
        dataIndex: 'description',
        width : 350}
    ]);

    this.paging = new Ext.PagingToolbar({
      store: this.ds,
      pageSize: 10,
      displayInfo: true,
      displayMsg: 'Displaying pages {0} - {1} of {2}',
      emptyMsg: "No pages to display"
    });

    // create the editor grid
    this.grid = new Ext.grid.GridPanel({
      store: this.ds,
      cm: cm,
      bbar: this.paging,
      footer: true,
      selModel: new Ext.grid.RowSelectionModel({singleSelect:true}),
      enableColLock : false,
      width:600,
      height:314,
      loadMask : true
    });

    // render it
//    this.grid.render();

//    var gridFoot = this.grid.getView().getFooterPanel(true);

    // add a paging toolbar to the grid's footer

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
//    this.paging.updateInfo();
    OpenPageDialog.superclass.show.call(this);
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


var OpenPageLocalDialog = function(editor) {

  this.panel = new Ext.Panel();

  OpenPageLocalDialog.superclass.constructor.call(this, {
    title : 'Open Process',
    modal : true,
    width : 600,
    height : 380,
    resizable : false,
    shadow : true,
    items : this.panel,
    buttons : [{
      text:'Open',
      scope:this,
      handler:this.submit
    },{
      text:'Cancel',
      scope:this,
      handler:this.hide
    }]
  });

  this.editor = editor;
}

Ext.extend(OpenPageLocalDialog, Ext.Window, {

  submit : function() {
    var json = afrous.lang.parseJSON(document.getElementById("textareaFileContent").value);
    this.editor.loadJson(json);
    this.hide();
  }
  ,

  hide: function() {
    if (this.PID) window.clearInterval(this.PID);
    OpenPageLocalDialog.superclass.hide.call(this);
  }
  ,

  show: function() {
    OpenPageLocalDialog.superclass.show.call(this);

    var html =[
    '<div style="padding: 10px;"><p>Please select a file with a page stored or paste page config here in the text area.</p>',
    '<form id="fileForm" method="POST" enctype="multipart/form-data" action="'+afrous.config.PROCESS_OPEN_URL+'" target="contentFileIframe">',
    '  <input type="file" name="fileInput" id="fileInput" value="" size="38" onchange="romulus.pageEditor.FileChooserEvent.onChangeFileChooser();" />',
    '</form>',
    '<textarea class="ext-mb-textarea" id="textareaFileContent" rows="14" cols="70"> </textarea>',
    '<iframe id="contentFileIframe" name="contentFileIframe" style="display: none;"/>',
    '</div>'].join("\n");

    this.panel.getEl().dom.innerHTML = html;

    this.PID = window.setInterval(function(){
      if(romulus.pageEditor.OpenPageLocalDialog.submit > 0)
      {
        var iframeDoc = document.getElementById("contentFileIframe").contentDocument;
        var text = iframeDoc.getElementById("json").value;
        if(document.getElementById("textareaFileContent").value != text)
        {
          document.getElementById("textareaFileContent").value = text;
          romulus.pageEditor.OpenPageLocalDialog.submit--;
        }
      }
    }, 100);
    document.getElementById("textareaFileContent").value = "";
    document.getElementById("fileInput").value = "";
  }
});


/**
 * @class SavePageDialog
 * @extends AbstractCallbackDialog
 */
var SavePageDialog = function(editor) {

  this.editor = editor;

  this.nameField = new Ext.form.Field({
    xtype:'textfield',
    fieldLabel : 'Name',
    name : 'name',
    width : 200
  });
  this.descriptionField = new Ext.form.Field({
    xtype:'textfield',
    fieldLabel : 'Description',
    name : 'description',
    width : 200
  });

  this.form = new Ext.form.FormPanel({  
    id:'formanchor-form',
    labelWidth:70,
    bodyStyle:'padding:15px',
    border:false,
    frame:true,
    items:[
      this.nameField,
      this.descriptionField
    ],
    buttons:[
    {
      text:'Save',
      scope:this,
      handler:this.submit
    },
    {
      text:'Cancel',
      scope:this,
      handler:this.hide
    }]
  });

  SavePageDialog.superclass.constructor.call(this, {
    title : 'Save Page',
    modal : true,
    width : 400,
    height : 165,
    resizable : false,
    shadow : true,
    items: this.form
  });

//  this.editor = editor;
//  this.addKeyListener(27, this.hide, this);
//
//  this.openBtn = this.addButton('Save', this.submit, this);
//  this.closeBtn = this.addButton('Close', this.hide, this);
}

Ext.extend(SavePageDialog, Ext.Window, {

  submit : function(){
    var name        = this.nameField.getValue();
    var description = this.descriptionField.getValue();

    if(name == "")
    {
      Ext.Msg.alert('Warning', 'Complete the "name" field');
      return;
    }

    var pageConfig = this.editor.toConfig();
    var json = afrous.lang.toJSON(pageConfig);

    var _this = this;
    var conn = new Ext.data.Connection();
    conn.request({
        url: romulus.pageEditor.config.PAGE_SAVE_URL,
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
              _this.editor.setPageKeyID(id);
              Ext.Msg.alert('Saved', 'Page saved correctly');
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
    SavePageDialog.superclass.show.call(this);
  }

});


var FileChooserEvent = defineClass({

  initialize : function() {
  }
  ,

  onChangeFileChooser : function() {
    document.getElementById("fileForm").submit();
    romulus.pageEditor.OpenPageLocalDialog.submit++;
  }
});

function defineClass(props)
{
  var f = function() { };
  f.prototype = props;
  return f;
}

romulus.pageEditor.RomulusPageEditor = RomulusPageEditorExt;

romulus.pageEditor.FileChooserEvent = new FileChooserEvent();
romulus.pageEditor.OpenPageLocalDialog = {};
romulus.pageEditor.OpenPageLocalDialog.submit = 0;

})();


