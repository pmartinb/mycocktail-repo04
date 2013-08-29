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

/**
 * Ajax Package
 */

(function() {

var ajax = new afrous.UnitActionPackage('Ajax');

ajax.register(new afrous.UnitAction({
  type : 'XMLHttp',
  label : 'XMLHttp call',
  description : '',
  inputs : [
    { name : 'path',
      label : 'Request Path',
      type : 'String' },
    { name : 'method',
      label : 'Method',
      type : 'String',
      options : ['GET','POST'] },
    { name : 'mimeType',
      label : 'MIME Type',
      type : 'String' }
  ]
  ,
  execute : function(request, callback) {
    afrous.ajax.request({
      path : request.params['path'],
      method : request.params['method'] || 'GET',
      mimeType : request.params['mimeType']
    }, callback);
  }

}));

ajax.register(new afrous.UnitAction({
  type : 'JSONP',
  label : 'JSONP call',
  description : '',
  inputs : [
    { name : 'url',
      label : 'Service URL',
      type : 'String',
      size : 'large' },
    { name : 'formatField',
      label : 'Response format',
      type : 'String',
      options : ['JSONP', 'JSON', 'XML'],
      selected : 'JSONP' },
    { name : 'jsonpParam',
      label : 'JSONP callback parameter',
      type : 'String' }
  ]
  ,
  execute : function(request, callback) {
    var format    = request.params['formatField'] || null;
    var url       = request.params['url'];
    var jsonParam = request.params['jsonpParam']  || null;
    var options   = {};
    if (jsonParam != null) {
        options.jsonpParam = request.params['jsonpParam'];
    }

    afrous.ajax.jsonp.invoke(url, callback, options, format);
  }
}))

// if in afrous editor
if (afrous.editor) {
  afrous.packages.loadScript(afrous.packages.scriptBaseURL + '/operators/ajax-operators-widgets.js');
}

afrous.packages.register(ajax, afrous.packages.scriptBaseURL + '/operators/ajax-operators.js');

})();
