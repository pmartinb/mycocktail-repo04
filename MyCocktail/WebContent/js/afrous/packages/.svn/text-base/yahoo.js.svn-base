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
 * Services.Yahoo Package
 */

(function() {

var yahoo = new afrous.UnitActionPackage('Services.Yahoo', {
  label : 'Yahoo!',
  icon : 'http://www.yahoo.com/favicon.ico'
});

yahoo.register(new afrous.UnitAction({
  type : 'WebSearch',
  label : 'Yahoo! Web Search',
  description : 'Yahoo! Web Search API. Returns search results for given keyword query.',
  allowDynamicInput : true,
  inputs : [
    { name : 'appid',
      label : 'application ID',
      type : 'String' },
    { name : 'query',
      label : 'query to search for',
      type : 'String' },
    { name : 'results',
      label : 'num of results',
      type : 'Integer' },
    { name : 'start',
      label : 'starting result position',
      type : 'Integer' }
  ]
  ,
  execute : function(request, callback) {
    var url = 'http://search.yahooapis.com/WebSearchService/V1/webSearch?output=json&';
    var pnames = "appid query region type results start format adult_ok similar_ok language country site subscription license".split(' ');
    afrous.lang.forEach(pnames, function(pname) {
      if (request.params[pname]) 
        url += pname + '=' + encodeURIComponent(request.params[pname]) + '&';
    });
    afrous.ajax.jsonp.invoke(url, callback);
  }

}));

yahoo.register(new afrous.UnitAction({
  type : 'RSS',
  label : 'Fetch RSS',
  description : 'Fetching RSS data from given URL, using Yahoo! Pipes RSS2JSON Feed.',
  inputs : [
    { name : 'rssurl',
      label : 'RSS url',
      type : 'String',
      size : 'large' }
  ]
  ,
  execute : function(request, callback) {
    var pipeId = 'Bu8sIkUH3BGA6wD_CB2yXQ';
    var url = 'http://pipes.yahoo.com/pipes/'+pipeId+'/run?_render=json&'
    url += 's='+encodeURIComponent(request.params['rssurl']);
    afrous.ajax.jsonp.invoke(url, callback, { jsonpParam : '_callback' });
  }

}));

yahoo.register(new afrous.UnitAction({
  type : 'TermExtraction',
  label : 'Term Extraction',
  description : 'The Term Extraction Web Service provides a list of significant words or phrases extracted from a larger content.',
  inputs : [
    { name : 'appid',
      label : 'application ID',
      type : 'String' },
    { name : 'context',
      label : 'context to extract terms',
      type : 'String' },
    { name : 'query',
      label : 'query to help extraction',
      type : 'String' }
  ]
  ,
  execute : function(request, callback) {
    var url = 'http://search.yahooapis.com/ContentAnalysisService/V1/termExtraction?output=json&';
    var pnames = "appid context query".split(' ');
    afrous.lang.forEach(pnames, function(pname) {
      if (request.params[pname])
        url += pname + '=' + encodeURIComponent(request.params[pname]) + '&';
    });
    afrous.ajax.jsonp.invoke(url, callback);
  }

}));

afrous.packages.register(yahoo, 'yahoo.js');


})();
