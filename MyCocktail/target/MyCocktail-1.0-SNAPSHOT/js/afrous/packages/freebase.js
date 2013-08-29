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

var freebase = new afrous.UnitActionPackage('Services.Freebase', {
  label : 'Freebase',
  icon : 'http://www.freebase.com/favicon.ico'
});

freebase.register(new afrous.UnitAction({
  type : 'FreebaseSearch',
  label : 'Freebase Search',
  description : 'Make Search from Freebase',
  inputs : [
//    {name : 'type',
//      label : 'Type',
//      type : 'String'}
  ]
  ,
  execute : function(request, callback) {
    var query = {query : {}};

    var conditions = [];
    for (var i=0; i<10; i++) {
      var property = request.params['property'+i];
      var operand = request.params['operand'+i];
      var value = request.params['value'+i];
      if (typeof property != 'undefined' &&
          typeof operand != 'undefined' &&
          typeof value != 'undefined') {
        conditions.push({property : property, operand : operand, value : value});
      }
    }

    for (var i=0; i<conditions.length; i++) {
      checkCondition(query.query, conditions[i]);
    }

    var url = 'http://api.freebase.com/api/service/mqlread?query=' + afrous.lang.toJSON(query);

    afrous.ajax.jsonp.invoke(url, callback);

    function checkCondition(query, condition) {
      switch (condition.operand) {
        case '>' :
          condition.property += '>';
          break;
        case '>=' :
          condition.property += '>=';
          break;
        case '<' :
          condition.property += '<';
          break;
        case '<=' :
          condition.property += '<=';
          break;
        case '!=' :
          condition.property += '!=';
          break;
        case 'includes' :
          condition.property += '~=';
          condition.value = '*'+condition.value+'*';
          break;
      }

      if (condition.value == "{}")
        condition.value = {};
      else if (condition.value == "[]")
        condition.value = [];
      else if (condition.value == "[{}]")
        condition.value = [{}];
      else if (condition.value == "null")
        condition.value = null;
      else if (/[0-9]+/.test(condition.value))
        condition.value = parseInt(condition.value);

      query[condition.property] = condition.value;
    }
  }

}));

// if in afrous editor
if (afrous.editor) {
  afrous.packages.loadScript(afrous.packages.scriptBaseURL + '/packages/freebase-widget.js');
}

afrous.packages.register(freebase, 'freebase.js');

})();
