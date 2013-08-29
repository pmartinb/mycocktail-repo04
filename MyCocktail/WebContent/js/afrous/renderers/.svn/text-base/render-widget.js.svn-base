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
 *
 * This program is a modification of Afrous JavaScript - Editor
 * which  is freely distributable under the terms of an MIT-style license.
 * Afrous JavaScript - Editor: (c) 2007 Shinichi Tomita
 */

(function() {

/*var ObjectInspectorDialog = function() {

  ObjectInspectorDialog.superclass.constructor.call(this, {
    title : 'Choose an attribute',
    modal : true,
    width : 600,
    height : 460,
    resizable : false,
    shadow : true
  });
  this.addKeyListener(27, this.hide, this);
  this.openBtn = this.addButton('Select', this.handleOpen, this);
  this.closeBtn = this.addButton('Close', this.hide, this);

  this.setup();

}

Ext.extend(ObjectInspectorDialog, afrous.editor.AbstractCallbackDialog, {

  setup : function() {
    this.formEl = this.body.createChild({ cls : 'af-dlg-form' });
    this.outputView = new afrous.editor.OutputTreeView(this.formEl.createChild(), 'Output', false);
  }
  ,

  show : function(value) {
    this.outputView.render(value);
    ObjectInspectorDialog.superclass.show.call(this);
  }
  ,

  handleOpen : function() {
    var selNode = this.outputView.outputTree.getSelectionModel().selNode;
    if(selNode != null)
    {
      var path = selNode.path;
      this.callback.call(this.scope, path);
      this.hide();
    }
  }

});
*/

var StandartRendererWidget = function() {
  StandartRendererWidget.superclass.constructor.apply(this, arguments);
}

Ext.extend(StandartRendererWidget, afrous.editor.ActionWidget, {

  renderInputFields : function() {
    StandartRendererWidget.superclass.renderInputFields.apply(this, arguments);

    afrous.lang.forEach(
      this.getPropertyFields(),
      function (field) {
        field.store.removeAll();
        field.control.on('beforequery', this.suggestProperties, this);
        /*field.control.on('select',      this.generateInputs,    this);*/
      },
      this
    );
  }
  ,

  getPropertyFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return /^(label|value|initialDate|finalDate|title|description|tagURL|tagName|tagSize|photoURL|photoLink)Field/.test(f.getName());
    });
  }
  ,

  suggestProperties : function() {
    var recordsField = afrous.lang.find(this.inputFields, function(f) {
      return f.getName()=='records';
    });
    this.processPanel.process.evaluate(
      recordsField.getValue(),
      this.handleArrayResult.createDelegate(this)
    );
  }
  ,

  handleArrayResult : function(result) {
    var elem = afrous.lang.cast('object[]', result.value)[0]
    if (afrous.lang.isObject(elem)) {
      var keys = afrous.lang.keys(elem);
      keys = afrous.lang.filter(keys, function(x) {
        return !/^(myCocktailName|myCocktailIcon)/.test(x);
      });
      afrous.lang.forEach(
        this.getPropertyFields(),
        function (field) {
          field.store.loadData(
            afrous.lang.map(keys, function(k){return [k, k]})
          ); 
        },
        this
      );
    }
  }
/*  ,

  generateInputs : function(field) {
    this.seletedField = field;
    var recordsField = afrous.lang.find(this.inputFields, function(f) {
      return f.getName()=='records';
    });
    this.processPanel.process.evaluate(
      recordsField.getValue(),
      this.generateSubObjects.createDelegate(this)
    );
  }
  ,

  generateSubObjects : function(result){
    var elem = null;
    if(afrous.lang.isArray(result.value))
      elem = result.value[0];
    else
      elem = result.value;
    elem = afrous.lang.cast('object', elem[this.seletedField.getValue()]);
    if (afrous.lang.isObject(elem)) {
      //var keys = afrous.lang.keys(elem);
      //var field = this.createBindField({ name : this.seletedField.getName()+"2",
      //                                            label : this.seletedField.getName()+"2",
      //                                            type : 'Object[]',
      //                                            options: keys});
      this.objectDialog = new ObjectInspectorDialog();
      this.objectDialog.setCallback(this.setFieldWithSubObject,this.seletedField);
      this.objectDialog.show(elem);
    }
  }
  ,

  setFieldWithSubObject: function(path){
    this.setValue(path);
  }*/

});

var CHART_TYPE = {
  AREA_CHART   : 'Area Chart',
  BAR_CHART    : 'Bar Chart',
  COLUMN_CHART : 'Column Chart',
  GEO_MAP      : 'Geo Map',
  LINE_CHART   : 'Line Chart',
  PIE_CHART    : 'Pie Chart',
  TABLE        : 'Table',
  ANNOTATED_TIMELINE_CHART : 'Annotated Timeline Chart'
}

var GoogleVisualizationWidget = function() {
  GoogleVisualizationWidget.superclass.constructor.apply(this, arguments);
}

Ext.extend(GoogleVisualizationWidget, StandartRendererWidget, {

  renderInputFields : function() {
    if (this.uaction.inputs) {
      afrous.lang.forEach(
        afrous.lang.values(this.uaction.inputs),
        function(inputDef) {this.createBindField(inputDef)},
        this
      );
    }

    var valueFields = {};
    afrous.lang.filter(
      afrous.lang.keys(this.actionDef.inputs || {}),
      function(key) {
        if(/^valueField[0-9]+/.test(key)) {
          valueFields[key] = this.actionDef.inputs[key];
        }
      },
      this
    );

    var valueFieldsNum = afrous.lang.keys(valueFields).length;
    if (valueFieldsNum == 0) {
      valueFieldsNum = 1;
      valueFields['valueField1'] = '';
      this.actionDef.inputs = {};
      this.actionDef.inputs['valueField1'] = '';
      this.actionDef.inputs['valueFields'] = valueFieldsNum;
    }

    for(var i=1; i<=valueFieldsNum; i++) {
      var field = this.createBindField({name : 'valueField'+i,
                                        label : 'Value Field #'+i,
                                        type : 'String',
                                        options : []});
      field.store.removeAll();
      field.control.on('beforequery', this.suggestProperties, this);
    }

    afrous.lang.forEach(
      afrous.lang.keys(this.actionDef.inputs || {}),
      function(key) {
        var field = afrous.lang.find(this.inputFields, function(f){
          return f.getName() == key
        });
        field.setValue(this.actionDef.inputs[key]);
      },
      this
    );

    afrous.lang.forEach(
      this.getPropertyFields(),
      function (field) {
        field.store.removeAll();
        field.control.on('beforequery', this.suggestProperties, this);
      },
      this
    );

    afrous.lang.forEach(
      this.getSelectFields(),
      function (field) {
        field.store.removeAll();
        field.control.on('select', this.generateInputs, this);
      },
      this
    );

    afrous.lang.forEach(
      this.getTypeFields(),
      function (field) {
        field.store.removeAll();
        field.control.on('select', this.changeMapType, this);
      },
      this
    );

    this.changeMapType();
  }
  ,

  getTypeFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return /^type/.test(f.getName());
    });
  }
  ,
  
  getPropertyFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return /^(labelField|valueField[0-9]+)/.test(f.getName());
    });
  }
  ,

  getSelectFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return /^valueFields/.test(f.getName());
    });
  }
  ,

  getValueFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return /^valueField[0-9]+/.test(f.getName());
    });
  }
  ,

  generateInputs : function() {

    var valueFieldsOld = this.getValueFields();

    var valueFields = afrous.lang.find(this.inputFields, function(f) {
      return f.getName()=='valueFields';
    });

    var num    = valueFields.getValue();
    var oldNum = valueFieldsOld.length;

    if(num < oldNum) {
      for(var i=oldNum; i>num; i--) {
        var field = afrous.lang.find(this.inputFields, function(f) {
          return f.getName()=='valueField'+i;
        });
        field.destroy();
      }
    } else if(num > oldNum) {
      for(var i=oldNum+1; i<=num; i++) {
        var field = this.createBindField({name : 'valueField'+i,
                                          label : 'Value Field #'+i,
                                          type : 'String',
                                          options : []});
        field.store.removeAll();
        field.control.on('beforequery', this.suggestProperties, this);
      }
    }
  }
  ,

  changeMapType : function() {

    var valueFieldsF = afrous.lang.find(this.inputFields, function(f) {
        return f.getName()=='valueFields';
    });
    var titleField = afrous.lang.find(this.inputFields, function(f) {
        return f.getName()=='title';
    });
    var vAxisField = afrous.lang.find(this.inputFields, function(f) {
        return f.getName()=='vAxis';
    });
    var hAxisField = afrous.lang.find(this.inputFields, function(f) {
        return f.getName()=='hAxis';
    });
    var labelField = afrous.lang.find(this.inputFields, function(f) {
        return f.getName()=='labelField';
    });

    var mapTypeField = afrous.lang.find(this.inputFields, function(f) {
      return f.getName()=='type';
    });

    var mapType = mapTypeField.getValue();

    var valueFieldsOld = this.getValueFields();
    var oldNum = valueFieldsOld.length;

    if(mapType == CHART_TYPE.PIE_CHART || mapType == CHART_TYPE.GEO_MAP) {
      for(var i=2; i<=oldNum; i++) {
        var field = afrous.lang.find(this.inputFields, function(f) {
          return f.getName()=='valueField'+i;
        });
        field.destroy();
      }
      valueFieldsF.setValue(1);
      
      valueFieldsF.control.setDisabled(true);
      vAxisField.setDisplayed(false);
      hAxisField.setDisplayed(false);
      if(mapType == CHART_TYPE.GEO_MAP) {
        titleField.setDisplayed(false);
      } else {
        titleField.setDisplayed(true);
      }
    } else  {
      valueFieldsF.control.setDisabled(false);
      titleField.setDisplayed(true);
      vAxisField.setDisplayed(true);
      hAxisField.setDisplayed(true);
    }

    if(mapType == CHART_TYPE.GEO_MAP)
      labelField.setLabel('Country Field');
    if(mapType == CHART_TYPE.ANNOTATED_TIMELINE_CHART)
      labelField.setLabel('Date Field');
    else
      labelField.setLabel('Label Field');
  }
});

var GoogleTableWidget = function() {
  GoogleTableWidget.superclass.constructor.apply(this, arguments);
}

Ext.extend(GoogleTableWidget, StandartRendererWidget, {

  renderInputFields : function() {
    if (this.uaction.inputs) {
      afrous.lang.forEach(
        afrous.lang.values(this.uaction.inputs),
        function(inputDef) {this.createBindField(inputDef)},
        this
      );
    }

    var columnFields = {};
    afrous.lang.filter(
      afrous.lang.keys(this.actionDef.inputs || {}),
      function(key) {
        if(/^col[0-9]+/.test(key)) {
          columnFields[key] = this.actionDef.inputs[key];
        }
      },
      this
    );

    var valueFieldsNum = afrous.lang.keys(columnFields).length;
    if (valueFieldsNum == 0) {
      valueFieldsNum = 1;
      columnFields['col1'] = '';
      this.actionDef.inputs = {};
      this.actionDef.inputs['col1'] = '';
      this.actionDef.inputs['columns'] = valueFieldsNum;
    }

    for(var i=1; i<=valueFieldsNum; i++) {
      var field = this.createBindField({name : 'col'+i,
                                        label : 'Column #'+i,
                                        type : 'String',
                                        options : []});
      field.store.removeAll();
      field.control.on('beforequery', this.suggestProperties, this);
    }

    afrous.lang.forEach(
      afrous.lang.keys(this.actionDef.inputs || {}),
      function(key) {
        var field = afrous.lang.find(this.inputFields, function(f){
          return f.getName() == key
        });
        field.setValue(this.actionDef.inputs[key]);
      },
      this
    );

    afrous.lang.forEach(
      this.getPropertyFields(),
      function (field) {
        field.store.removeAll();
        field.control.on('beforequery', this.suggestProperties, this);
      },
      this
    );

    afrous.lang.forEach(
      this.getSelectFields(),
      function (field) {
        field.store.removeAll();
        field.control.on('select', this.generateInputs, this);
      },
      this
    );
  }
  ,

  getPropertyFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return /^(col[0-9]+)/.test(f.getName());
    });
  }
  ,

  getSelectFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return /^columns/.test(f.getName());
    });
  }
  ,

  getValueFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return /^col[0-9]+/.test(f.getName());
    });
  }
  ,

  generateInputs : function() {

    var valueFieldsOld = this.getValueFields();

    var valueFields = afrous.lang.find(this.inputFields, function(f) {
      return f.getName()=='columns';
    });

    var num    = valueFields.getValue();
    var oldNum = valueFieldsOld.length;

    if(num < oldNum) {
      for(var i=oldNum; i>num; i--) {
        var field = afrous.lang.find(this.inputFields, function(f) {
          return f.getName()=='col'+i;
        });
        field.destroy();
      }
    } else if(num > oldNum) {
      for(var i=oldNum+1; i<=num; i++) {
        var field = this.createBindField({name : 'col'+i,
                                          label : 'Column #'+i,
                                          type : 'String',
                                          options : []});
        field.store.removeAll();
        field.control.on('beforequery', this.suggestProperties, this);
      }
    }
  }
});

afrous.editor.widgets.register('Renderer.Plotr.Pie', StandartRendererWidget);
afrous.editor.widgets.register('Renderer.Plotr.Bar', StandartRendererWidget);
afrous.editor.widgets.register('Renderer.GoogleMaps.GoogleMapsMarker', StandartRendererWidget);
afrous.editor.widgets.register('Renderer.SmileWidgets.Timeline',       StandartRendererWidget);
afrous.editor.widgets.register('Renderer.Widgets.ImagesWidget',        StandartRendererWidget);
afrous.editor.widgets.register('Renderer.Widgets.TagCloudWidget',      StandartRendererWidget);
afrous.editor.widgets.register('Renderer.GoogleVisualization.GoogleChart', GoogleVisualizationWidget);
afrous.editor.widgets.register('Renderer.GoogleVisualization.Table',       GoogleTableWidget);

})();

