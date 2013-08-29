/*
 * MyCocktail Mashup Builder
 * David del Pozo González (david.del.pozo--at--logica.com)
 * Rodrigo Illera Camargo (rodrigo.illera--at--logica.com)
 * Copyright 2012 Logica
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

  setupLayout: function() {
    EditorAppExt.superclass.setupLayout.call(this);
    this.publishMenuGadget.insert(1,new Ext.menu.Item({ text : 'Deploy in Wookie',
                                                        handler : function(){ this.deployInWookie() },
                                                        cls: 'x-menu-item af-wookie-widget-btn',
                                                        scope : this }));
  }
  ,
  
  deployInWookie : function() {
    if (!this.deployInWookieDialog) {
      this.deployInWookieDialog = new DeployInWookieDialog(this);
    } 
    this.deployInWookieDialog.show();
  }
});


/**
 * @class LibraryPanel
 * @extends Ext.NestedLayoutPanel
 */
var LibraryPanelExt = function(el, config) {
  LibraryPanelExt.superclass.constructor.call(this,el,config);
};

Ext.extend(LibraryPanelExt, afrous.editor.LibraryPanel, {
  setupLayout : function() {
    LibraryPanelExt.superclass.setupLayout.call(this);
    this.loadMenu.insert(1,new Ext.menu.Item({ text : 'Import Service from Omelette Mashup Repository',
                                             handler : function(){ this.openOmeletteMashupRegistryDialog() },
                                             scope : this }));

    this.omeletteMashupRegistryDialog = new OmeletteMashupRegistryDialog();
    this.omeletteMashupRegistryDialog.setCallback(this.editorApp.loadWADL, this.editorApp);
  }
  ,
  
  openOmeletteMashupRegistryDialog : function() {
    this.omeletteMashupRegistryDialog.show();
  }

});

/**
 * @class ActionsPanel
 * @extends Ext.NestedLayoutPanel
 */
var ActionsPanelExt = function(el, config) {
  ActionsPanelExt.superclass.constructor.call(this,el,config);
  
};

Ext.extend(ActionsPanelExt, afrous.editor.ActionsPanel, {

   createActionWidget : function(config) {
      var widget = ActionsPanelExt.superclass.createActionWidget.call(this, config);
      getRecommendations("ondrop", "action", widget.actionDef);
      return widget;
  }
  ,

  handleDestroyWidget : function(widget) {
      ActionsPanelExt.superclass.handleDestroyWidget.call(this, widget);
      getRecommendations("ondelete", "actions", widget.actionDef.name);
  }
  ,

  handleFocusWidget : function(widget) {
      ActionsPanelExt.superclass.handleFocusWidget.call(this, widget);
      getRecommendations("onfocus", "action.inputs", widget.actionDef.name);
  }
  
});

/**
 * @class DeployInWookieDialog
 * @extends AbstractCallbackDialog
 */
var DeployInWookieDialog = function(editor) {

  DeployInWookieDialog.superclass.constructor.call(this, {
    title : 'Deploy in Wookie',
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

Ext.extend(DeployInWookieDialog, afrous.editor.AbstractCallbackDialog, {

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
    this.iframeExportToW3CWidget.src = afrous.config.OMELETTE_WOOKIE_URL + '?page='+afrous.url.urlEncode(this.editor.generateHTML()) +
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
    DeployInWookieDialog.superclass.show.call(this);
  }

});


/**
 * @class OmeletteMashupRegistryDialog
 * @extends AbstractCallbackDialog
 */
var OmeletteMashupRegistryDialog = function() {

  OmeletteMashupRegistryDialog.superclass.constructor.call(this, {
    title : 'Open Service from Omelette Mashup Repository',
    modal : true,
    width : 780,
    height : 580,
    resizable : false,
    shadow : true
  });

  this.addKeyListener(27, this.hide, this);
  this.openBtn = this.addButton('Open', this.handleOpen, this);
  this.closeBtn = this.addButton('Close', this.hide, this);

  this.setup();
}

Ext.extend(OmeletteMashupRegistryDialog, afrous.editor.AbstractCallbackDialog, {

  setup : function() {

    this.ds = new Ext.data.Store({
      proxy: new Ext.data.ScriptTagProxy({
        url: afrous.config.OMELETTE_OMR_URL
      }),

      reader: new Ext.data.JsonReader({
         root: 'services',
         id: 'descriptionUrl',
         fields : [ 'service', 'name', 'descriptionUrl', 'type']
      }),

      remoteSort: true
    });

    var cm = new Ext.grid.ColumnModel([
      { header: "Name",
        dataIndex: 'name',
        width : 150,
        css: 'white-space:normal;' },
      { header: "Type",
        dataIndex: 'type',
        width : 150,
        css: 'white-space:normal;' },
      { header: "Service",
        dataIndex: 'service',
        width : 150,
        css: 'white-space:normal;' },
      { header: "Description Url",
        dataIndex: 'descriptionUrl',
        width : 350,
        css: 'white-space:normal;' }
    ]);

    this.gridEl = this.body.createChild({ cls : 'af-dlg-grid-services' });
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
    OmeletteMashupRegistryDialog.superclass.show.call(this);
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
      var url = selections[0].data.descriptionUrl;
      this.callback.call(this.scope, url);
      this.hide();
    }
  }

});

function getRecommendations(eventType, eventSrc, obj){
  /*
  if (eventType == "ondrop")
      window.alert("The component "+obj.name+" has been added.");
  if (eventType == "ondelete")
      window.alert("The component "+obj+" has been erased.");
  if (eventType == "onfocus")
      window.alert("The user has focused on "+obj+" component.");
  */
 
}

afrous.editor.EditorApp    = EditorAppExt;
afrous.editor.LibraryPanel = LibraryPanelExt;
afrous.editor.ActionsPanel = ActionsPanelExt;

afrous.config = afrous.lang.extend({
  OMELETTE_OMR_URL    : afrous.baseURL + '/OMR',
  OMELETTE_WOOKIE_URL : afrous.baseURL + '/WidgetLibrary'
}, afrous.config || {});

})();