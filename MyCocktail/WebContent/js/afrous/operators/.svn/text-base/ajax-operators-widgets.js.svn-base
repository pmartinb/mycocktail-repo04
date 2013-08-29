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

var JSONPWidget = function() {
  JSONPWidget.superclass.constructor.apply(this, arguments);
}

Ext.extend(JSONPWidget, afrous.editor.ActionWidget, {

  renderInputFields : function() {
    JSONPWidget.superclass.renderInputFields.apply(this, arguments);

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
      return /^(format)Field/.test(f.getName());
    });
  }
  ,

  getCallbackParameterField : function() {
    return afrous.lang.find(this.inputFields, function(f) {
      return f.getName()=='jsonpParam';
    });
  }
  ,

  generateInputs : function() {
    var formatField = afrous.lang.find(this.inputFields, function(f) {
      return f.getName()=='formatField';
    });

    var field = this.getCallbackParameterField();
    var format = formatField.getValue();
    if(format == 'JSON' || format == 'XML')
    {
      if(field)
        field.destroy();
    }
    else if(format == 'JSONP')
    {
      if(!field)
        this.createBindField({ name : 'jsonpParam',
                              label : 'JSONP callback parameter',
                               type : 'String' });
    }
  }

});

afrous.editor.widgets.register('Ajax.JSONP', JSONPWidget);

})();

