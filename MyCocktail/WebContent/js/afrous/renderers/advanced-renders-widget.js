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

var DivWidget = function() {
  DivWidget.superclass.constructor.apply(this, arguments);
}

Ext.extend(DivWidget, afrous.editor.ActionWidget, {

  renderInputFields : function() {
    if (this.uaction.inputs) {
      afrous.lang.forEach(
        afrous.lang.values(this.uaction.inputs),
        function(inputDef) { this.createBindField(inputDef) },
        this
      );
    }

    var divs = {};
    afrous.lang.filter(
      afrous.lang.keys(this.actionDef.inputs || {}),
      function(key) {
        if(/^div[0-9]+/.test(key)) {
          divs[key] = this.actionDef.inputs[key];
        }
      },
      this
    );

    if(afrous.lang.keys(divs).length == 0) {
      divs['div1'] = '';
      this.actionDef.inputs = {};
      this.actionDef.inputs['div1'] = '';
      this.actionDef.inputs['rowField']    = 1;
      this.actionDef.inputs['columnField'] = 1;
    }

    afrous.lang.forEach(
      afrous.lang.keys(divs || {}),
      function(divKey) {
        this.createBindField({ name : divKey, label : divKey, type : 'Object' });
      },
      this
    );

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
        field.control.on('select', this.generateInputs, this);
      },
      this
    );
  }
  ,

  getPropertyFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return /^(row|column)Field/.test(f.getName());
    });
  }
  ,

  getDivFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return /^div[0-9]+/.test(f.getName());
    });
  }
  ,

  generateInputs : function() {
    var rowsField = afrous.lang.find(this.inputFields, function(f) {
      return f.getName()=='rowField';
    });
    var colsField = afrous.lang.find(this.inputFields, function(f) {
      return f.getName()=='columnField';
    });
    var cols  = colsField.getValue();
    var rows  = rowsField.getValue();
    var cells = cols * rows;

    var divFields = this.getDivFields();
    var oldCells = divFields.length;

    if(cells < oldCells) {
      for(var i=oldCells; i>cells; i--) {
        var field = afrous.lang.find(this.inputFields, function(f) {
          return f.getName()=='div'+i;
        });
        field.destroy();
      }
    } else if(cells > oldCells) {
      for(var i=oldCells+1; i<=cells; i++) {
        var field = this.createBindField({ name : 'div'+i,
                                           label : 'div'+i,
                                           type : 'Object' });
      }
    }
  }

});

afrous.editor.widgets.register('Renderer.AdvancedRenders.Div', DivWidget);

})();

