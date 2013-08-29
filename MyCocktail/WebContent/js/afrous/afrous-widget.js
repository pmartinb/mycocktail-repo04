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
 * This program is a modification of Afrous JavaScript - Standard Widgets
 * which  is freely distributable under the terms of an MIT-style license.
 * Afrous JavaScript - Standard Widgets: (c) 2007 Shinichi Tomita
 */

(function() {

var ArrayBindingWidget = function() {
  ArrayBindingWidget.superclass.constructor.apply(this, arguments);
}

Ext.extend(ArrayBindingWidget, afrous.editor.ActionWidget, {

  renderInputFields : function() {
    ArrayBindingWidget.superclass.renderInputFields.apply(this, arguments);

    afrous.lang.forEach(
      this.getPropertyFields(),
      function (field) {
        field.store.removeAll();
        field.control.on('beforequery', this.suggestProperties, this);
      },
      this
    );
  }
  ,

  getPropertyFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return f.getName()=='property';
    });
  }
  ,

  suggestProperties : function() {
    var arrField = afrous.lang.find(this.inputFields, function(f) {
      return f.getName()=='array';
    });
    this.processPanel.process.evaluate(
      arrField.getValue(),
      this.handleArrayResult.createDelegate(this)
    );
  }
  ,

  handleArrayResult : function(result) {
    var elem = afrous.lang.cast('object[]', result.value)[0]
    if (afrous.lang.isObject(elem)) {
      var keys = afrous.lang.keys(elem);
      keys = keys.filter(function(x) {
        return !/^(myCocktailName|myCocktailIcon)/.test(x);
      });
      afrous.lang.forEach(
        this.getPropertyFields(),
        function (field) {
          field.store.loadData(
            afrous.lang.map(keys, function(k){ return [k, k] })
          ); 
        },
        this
      );
    }
  }

});

afrous.editor.widgets.register('Array.Pluck', ArrayBindingWidget);
afrous.editor.widgets.register('Array.SortBy', ArrayBindingWidget);
afrous.editor.widgets.register('Array.Unique', ArrayBindingWidget);
afrous.editor.widgets.register('Array.GroupBy', ArrayBindingWidget);
afrous.editor.widgets.register('Array.Count', ArrayBindingWidget);
afrous.editor.widgets.register('Array.Remove', ArrayBindingWidget);


/**
 * @class ArrayFilterWidget
 * @extends ArrayBindingWidget
 */
var ArrayFilterWidget = function() {
  ArrayFilterWidget.superclass.constructor.apply(this, arguments);
}

Ext.extend(ArrayFilterWidget, ArrayBindingWidget, {

  renderInputFields : function() {
    var inputs = this.actionDef.inputs;

    this.inputToolbar.el.show();
    this.inputToolbar.addButton({
      text: 'Add New Condition',
      cls: 'x-btn-text-icon af-add-btn',
      handler: this.createCondition.createDelegate(this)
    });

    var arrayField = this.createBindField(this.uaction.inputs['array']);
    if (inputs && inputs['array']) {
      arrayField.setValue(inputs['array']);
    }
    var modeField = this.createBindField(this.uaction.inputs['mode']);
    if (inputs && inputs['mode']) {
      modeField.setValue(inputs['mode']);
    }

    this.conditions = [];

    for (var i=0; i<10; i++) {
      var prop = 'property'+i;
      var oper = 'operand'+i;  
      var val = 'value'+i;
      if (inputs &&
          typeof inputs[prop] != 'undefined' &&
          typeof inputs[oper] != 'undefined' && 
          typeof inputs[val] != 'undefined') {
        var condition = this.createCondition();
        condition.property.setValue(inputs[prop]);
        condition.operand.setValue(inputs[oper]);
        condition.valfield.setValue(inputs[val]);
      }
    }

  }
  ,

  getPropertyFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return f.getName().indexOf('property')==0;
    });
  }
  ,

  createCondition : function() {
    var condition = new FilterConditionFieldSet(this.inputArea.createChild(), this, this.conditions.length);
    condition.property.on('change', this.handleChangeBinding, this);
    condition.property.on('destroy', this.destroyBindField, this);
    condition.operand.on('change', this.handleChangeBinding, this);
    condition.operand.on('destroy', this.destroyBindField, this);
    condition.valfield.on('change', this.handleChangeBinding, this);
    condition.valfield.on('destroy', this.destroyBindField, this);
    this.inputFields.push(condition.property);
    this.inputFields.push(condition.operand);
    this.inputFields.push(condition.valfield);
    this.conditions.push(condition);
    return condition;
  }

});


/**
 * @class FilterConditionFieldSet
 */
var FilterConditionFieldSet = function(el, widget, index) {
  this.el = el;
  this.el.addClass('af-actionfield');

  this.widget = widget;
 
  var form = new Ext.form.Form({ labelWidth : 10 });

  this.deleteBtn = new Ext.form.TriggerField({
    width : 10,
    cls : 'af-actionfield-delete',
    triggerClass : 'af-actionfield-delete-btn'
  });
  this.deleteBtn.onTriggerClick = this.destroy.createDelegate(this);

  var property = new afrous.editor.SelectBox({
    name : 'property'+index,
    options : [],
    editable : true,
    width : 150
  });
  property.on('beforequery', widget.suggestProperties, widget);
  
  var operand = new afrous.editor.SelectBox({
    name : 'operand'+index,
    width : 100,
    options : [ '=', '<', '<=', '>', '>=', '!=', 'includes', 'not includes', 'matches' ] 
  });

  var valfield = new Ext.form.TextField({
    name : 'value'+index,
    selectOnFocus : true,
    width : 150
  });
 
  form.column({ hideLabels : true, width : 20 }, this.deleteBtn);
  form.column({ hideLabels : true, width : 160, style : 'margin-left:10px' }, property);
  form.column({ hideLabels : true, width : 110, style : 'margin-left:10px' }, operand);
  form.column({ hideLabels : true, width : 160, style : 'margin-left:10px', clear : true }, valfield);
  form.render(this.el);

  this.property = new ControlField(property);
  this.property.store = property.store;
  this.operand = new ControlField(operand);
  this.valfield = new ControlField(valfield);

}

FilterConditionFieldSet.prototype = {
  destroy : function() {
    this.property.destroy();
    this.operand.destroy();
    this.valfield.destroy();
    this.el.remove();
  }
}

/**
 * @class ControlField
 * @extends afrous.editor.ActionInputField
 */
var ControlField = function(control) {
  this.control = control;
  this.control.on('change', this.handleChange, this);

  this.dropTarget = new Ext.dd.DropTarget(this.control.el, {
    ddGroup : 'BindingObjectDD',
    overClass : 'af-actionfield-bind-dragover'
  }); 

  this.dropTarget.notifyOver = this.handleOver.createDelegate(this);
  this.dropTarget.notifyDrop = this.handleDrop.createDelegate(this);

  this.addEvents({
    'change' : true,
    'destroy' : true
  });
}

Ext.extend(ControlField, afrous.editor.ActionInputField, {

  getName : function() {
    return this.control.getName();
  }  
  ,

  getValue : function() {
    return this.control.getValue();
  }
  ,

  destroy : function() {
    this.control.un('change', this.handleChange);
    this.fireEvent('destroy', this);
  }

});


afrous.editor.widgets.register('Array.Filter', ArrayFilterWidget);


var ComparatorBindingWidget = function() {
  ComparatorBindingWidget.superclass.constructor.apply(this, arguments);
}

Ext.extend(ComparatorBindingWidget, afrous.editor.ActionWidget, {

  renderInputFields : function() {
    ComparatorBindingWidget.superclass.renderInputFields.apply(this, arguments);

    afrous.lang.forEach(
      this.getPropertyFields(),
      function (field) {
        field.store.removeAll();
        field.control.on('beforequery', this.suggestProperties, this);
      },
      this
    );
  }
  ,

  getPropertyFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return f.getName()=='property';
    });
  }
  ,

  suggestProperties : function() {
    var arrField = afrous.lang.find(this.inputFields, function(f) {
      return f.getName()=='array';
    });
    this.processPanel.process.evaluate(
      arrField.getValue(),
      this.handleArrayResult.createDelegate(this)
    );
  }
  ,

  handleArrayResult : function(result) {
    var elem = afrous.lang.cast('object[]', result.value)[0]
    if (afrous.lang.isObject(elem)) {
      var keys = afrous.lang.keys(elem);
      keys = keys.filter(function(x) {
        return !/^(myCocktailName|myCocktailIcon)/.test(x);
      });
      afrous.lang.forEach(
        this.getPropertyFields(),
        function (field) {
          field.store.loadData(
            afrous.lang.map(keys, function(k){ return [k, k] })
          );
        },
        this
      );
    }
  }

});

/**
 * @class ComparatorWidget
 * @extends ComparatorBindingWidget
 */
var ComparatorWidget = function() {
  ComparatorWidget.superclass.constructor.apply(this, arguments);
}

Ext.extend(ComparatorWidget, ComparatorBindingWidget, {

  renderInputFields : function() {
    var inputs = this.actionDef.inputs;

    this.inputToolbar.el.show();
    this.inputToolbar.addButton({
      text: 'Add New Condition',
      cls: 'x-btn-text-icon af-add-btn',
      handler: this.createCondition.createDelegate(this)
    });

    var modeField = this.createBindField(this.uaction.inputs['mode']);
    if (inputs && inputs['mode']) {
      modeField.setValue(inputs['mode']);
    }

    this.conditions = [];

    for (var i=0; i<10; i++) {
      var prop = 'property'+i;
      var oper = 'operand'+i;
      var val = 'value'+i;
      if (inputs &&
          typeof inputs[prop] != 'undefined' &&
          typeof inputs[oper] != 'undefined' &&
          typeof inputs[val] != 'undefined') {
        var condition = this.createCondition();
        condition.property.setValue(inputs[prop]);
        condition.operand.setValue(inputs[oper]);
        condition.valfield.setValue(inputs[val]);
      }
    }

  }
  ,

  getPropertyFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return f.getName().indexOf('property')==0;
    });
  }
  ,

  createCondition : function() {
    var condition = new ComparatorConditionFieldSet(this.inputArea.createChild(), this, this.conditions.length);
    condition.property.on('change', this.handleChangeBinding, this);
    condition.property.on('destroy', this.destroyBindField, this);
    condition.operand.on('change', this.handleChangeBinding, this);
    condition.operand.on('destroy', this.destroyBindField, this);
    condition.valfield.on('change', this.handleChangeBinding, this);
    condition.valfield.on('destroy', this.destroyBindField, this);
    this.inputFields.push(condition.property);
    this.inputFields.push(condition.operand);
    this.inputFields.push(condition.valfield);
    this.conditions.push(condition);
    return condition;
  }

});


/**
 * @class ComparatorConditionFieldSet
 */
var ComparatorConditionFieldSet = function(el, widget, index) {
  this.el = el;
  this.el.addClass('af-actionfield');

  this.widget = widget;

  var form = new Ext.form.Form({ labelWidth : 10 });

  this.deleteBtn = new Ext.form.TriggerField({
    width : 10,
    cls : 'af-actionfield-delete',
    triggerClass : 'af-actionfield-delete-btn'
  });
  this.deleteBtn.onTriggerClick = this.destroy.createDelegate(this);

  var property = new Ext.form.TextField({
    name : 'property'+index,
    selectOnFocus : true,
    width : 150
  });
//  property.on('beforequery', widget.suggestProperties, widget);

  var operand = new afrous.editor.SelectBox({
    name : 'operand'+index,
    width : 100,
    options : [ '=', '<', '<=', '>', '>=', '!=', 'includes', 'not includes', 'matches', 'is empty', 'is null' ]
  });

  var valfield = new Ext.form.TextField({
    name : 'value'+index,
    selectOnFocus : true,
    width : 150
  });

  form.column({ hideLabels : true, width : 20 }, this.deleteBtn);
  form.column({ hideLabels : true, width : 160, style : 'margin-left:10px' }, property);
  form.column({ hideLabels : true, width : 110, style : 'margin-left:10px' }, operand);
  form.column({ hideLabels : true, width : 160, style : 'margin-left:10px', clear : true }, valfield);
  form.render(this.el);

  this.property = new ControlField(property);
  this.property.store = property.store;
  this.operand = new ControlField(operand);
  this.valfield = new ControlField(valfield);

}

ComparatorConditionFieldSet.prototype = {
  destroy : function() {
    this.property.destroy();
    this.operand.destroy();
    this.valfield.destroy();
    this.el.remove();
  }
}

afrous.editor.widgets.register('Basic.Comparator', ComparatorWidget);


var ReplaceBindingWidget = function() {
  ReplaceBindingWidget.superclass.constructor.apply(this, arguments);
}

Ext.extend(ReplaceBindingWidget, afrous.editor.ActionWidget, {

  renderInputFields : function() {
    ReplaceBindingWidget.superclass.renderInputFields.apply(this, arguments);

    afrous.lang.forEach(
      this.getPropertyFields(),
      function (field) {
        field.store.removeAll();
        field.control.on('beforequery', this.suggestProperties, this);
      },
      this
    );
  }
  ,

  getPropertyFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return f.getName()=='property';
    });
  }
  ,

  suggestProperties : function() {
    var arrField = afrous.lang.find(this.inputFields, function(f) {
      return f.getName()=='array';
    });
    this.processPanel.process.evaluate(
      arrField.getValue(),
      this.handleArrayResult.createDelegate(this)
    );
  }
  ,

  handleArrayResult : function(result) {
    var elem = afrous.lang.cast('object[]', result.value)[0]
    if (afrous.lang.isObject(elem)) {
      var keys = afrous.lang.keys(elem);
      keys = keys.filter(function(x) {
        return !/^(myCocktailName|myCocktailIcon)/.test(x);
      });
      afrous.lang.forEach(
        this.getPropertyFields(),
        function (field) {
          field.store.loadData(
            afrous.lang.map(keys, function(k){ return [k, k] })
          );
        },
        this
      );
    }
  }

});

/**
 * @class ReplaceWidget
 * @extends ReplaceBindingWidget
 */
var ReplaceWidget = function() {
  ReplaceWidget.superclass.constructor.apply(this, arguments);
}

Ext.extend(ReplaceWidget, ReplaceBindingWidget, {

  renderInputFields : function() {
    var inputs = this.actionDef.inputs;

    this.inputToolbar.el.show();
    this.inputToolbar.addButton({
      text: 'Add New Condition',
      cls: 'x-btn-text-icon af-add-btn',
      handler: this.createCondition.createDelegate(this)
    });

    var arrayField = this.createBindField(this.uaction.inputs['string']);
    if (inputs && inputs['string']) {
      arrayField.setValue(inputs['string']);
    }

    this.conditions = [];

    for (var i=0; i<10; i++) {
      var prop = 'property'+i;
      var oper = 'operand'+i;
      var val = 'value'+i;
      if (inputs &&
          typeof inputs[prop] != 'undefined' &&
          typeof inputs[oper] != 'undefined' &&
          typeof inputs[val] != 'undefined') {
        var condition = this.createCondition();
        condition.property.setValue(inputs[prop]);
        condition.operand.setValue(inputs[oper]);
        condition.valfield.setValue(inputs[val]);
      }
    }

  }
  ,

  getPropertyFields : function() {
    return afrous.lang.filter(this.inputFields, function(f) {
      return f.getName().indexOf('property')==0;
    });
  }
  ,

  createCondition : function() {
    var condition = new ReplaceConditionFieldSet(this.inputArea.createChild(), this, this.conditions.length);
    condition.property.on('change', this.handleChangeBinding, this);
    condition.property.on('destroy', this.destroyBindField, this);
    condition.operand.on('change', this.handleChangeBinding, this);
    condition.operand.on('destroy', this.destroyBindField, this);
    condition.valfield.on('change', this.handleChangeBinding, this);
    condition.valfield.on('destroy', this.destroyBindField, this);
    this.inputFields.push(condition.property);
    this.inputFields.push(condition.operand);
    this.inputFields.push(condition.valfield);
    this.conditions.push(condition);
    return condition;
  }

});


/**
 * @class ReplaceConditionFieldSet
 */
var ReplaceConditionFieldSet = function(el, widget, index) {
  this.el = el;
  this.el.addClass('af-actionfield');

  this.widget = widget;

  var form = new Ext.form.Form({ labelWidth : 10 });

  this.deleteBtn = new Ext.form.TriggerField({
    width : 10,
    cls : 'af-actionfield-delete',
    triggerClass : 'af-actionfield-delete-btn'
  });
  this.deleteBtn.onTriggerClick = this.destroy.createDelegate(this);

  var find = new Ext.form.TextField({
    name : 'property'+index,
    selectOnFocus : true,
    width : 150
  });

  var replace = new Ext.form.TextField({
    name : 'value'+index,
    selectOnFocus : true,
    width : 150
  });

  var flags = new afrous.editor.SelectBox({
    name : 'operand'+index,
    width : 110,
    options : [ 'None', 'Global (g)', 'Ignore Case (i)', 'Multiple Lines (m)', 'gi', 'gm', 'im', 'gim' ]
  });

  form.column({ hideLabels : true, width : 20 }, this.deleteBtn);
  form.column({ hideLabels : true, width : 155, style : 'margin-left:10px' }, find);
  form.column({ hideLabels : true, width : 155, style : 'margin-left:10px', clear : true }, replace);
  form.column({ hideLabels : true, width : 115, style : 'margin-left:10px' }, flags);
  form.render(this.el);

  this.property = new ControlField(find);
  this.property.store = find.store;
  this.operand = new ControlField(flags);
  this.valfield = new ControlField(replace);

}

ReplaceConditionFieldSet.prototype = {
  destroy : function() {
    this.property.destroy();
    this.operand.destroy();
    this.valfield.destroy();
    this.el.remove();
  }
}

afrous.editor.widgets.register('String.Replace', ReplaceWidget);

})();
