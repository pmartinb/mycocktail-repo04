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
 * Services.Google Package
 */

(function() {

var apikey = 'ABQIAAAAQLVYVvhTjXRPtKDa9AsPlhQs1SMlRZa-qyzdhC9kofgBeB67sRRcX48ZCyilXhFK6qqej_uY3YV6AA';
// var apikey = 'internal';

var goog = new afrous.UnitActionPackage('Services.Google', {
  label : 'Google',
  icon : 'http://www.google.com/favicon.ico'
});

goog.register(new afrous.UnitAction({
  type : 'Search',
  label : 'Google AJAX Search',
  description : 'Google AJAX Search API. Returns search results for given keyword query.',
  inputs : [
    { name : 'query',
      label : 'query to search for',
      type : 'String' }
  ]
  ,
  execute : function(request, callback) {
    var url = 'http://www.google.com/uds/GwebSearch?context=0&lstkp=0&rsz=large&v=1.0&key='+apikey+'&q='+encodeURIComponent(request.params['query']);
    afrous.ajax.jsonp.invoke(url, {
      onSuccess : function(ret) {
        if (ret[2]=='200') {
          callback.onSuccess(ret[1]);
        } else { 
          callback.onFailure({ error : ret[2], message : ret[3] });
        } 
      },
      onFailure : callback.onFailure
    });
  }
  

}));


goog.register(new afrous.UnitAction({
  type : 'RSS',
  label : 'Google AJAX Feed',
  description : 'Google AJAX Feed API. Fetching RSS/Atom feed of the URL.',
  inputs : [
    { name : 'rssurl',
      label : 'RSS url',
      type : 'String',
      size : 'large' }
  ]
  ,
  execute : function(request, callback) {
    var rssurl = request.params['rssurl'];
    var url = 'http://www.google.com/uds/Gfeeds?context=0&output=json&num=20&v=1.0&key='+apikey+'&q='+encodeURIComponent(rssurl);
    afrous.ajax.jsonp.invoke(url, {
      onSuccess : function(ret) {
        if (ret[2]=='200') {
          callback.onSuccess(ret[1]);
        } else { 
          callback.onFailure({ error : ret[2], message : ret[3] });
        } 
      },
      onFailure : callback.onFailure
    });
  }

}));


goog.register(new afrous.UnitAction({
  type : 'LookupFeed',
  label : 'Google AJAX Lookup Feed',
  description : 'Google AJAX Lookup Feed API. Lookups atom/rss URL from given URL.',
  inputs : [
    { name : 'url',
      label : 'URL',
      type : 'String',
      size : 'large' }
  ]
  ,
  execute : function(request, callback) {
    var url = request.params['url'];
    var requrl = 'http://www.google.com/uds/GlookupFeed?context=0&v=1.0&key='+apikey+'&q='+encodeURIComponent(url);
    afrous.ajax.jsonp.invoke(requrl, {
      onSuccess : function(ret) {
        if (ret[2]=='200') {
          callback.onSuccess(ret[1]);
        } else { 
          callback.onFailure({ error : ret[2], message : ret[3] });
        } 
      },
      onFailure : callback.onFailure
    });
  }

}));

var LANGS = {'Albanian':   'sq',
             'Arabic':     'ar',
             'Bulgarian':  'bg',
             'Catalan':    'ca',
             'Chinese (Simplified)':  'zh-CN',
             'Chinese (Traditional)': 'zh-TW',
             'Croatian':   'hr',
             'Czech':      'cs',
             'Danish':     'da',
             'Dutch':      'nl',
             'English':    'en',
             'Estonian':   'et',
             /*'Filipino':   '',*/
             'Galician':   'gl',
             'German':     'de',
             'Greek':      'el',
             'Hebrew':     'iw',
             'Hindi':      'hi',
             'Hungarian':  'hu',
             'Indonesian': 'id',
             'Finnish':    'fi',
             'French':     'fr',
             'Italian':    'it',
             'Japanese':   'jp',
             'Korean':     'ko',
             'Latvian':    'lv',
             'Lithuanian': 'lt',
             'Maltese':    'mt',
             'Norwegian':  'no',
             /*'Persian':    '',*/
             'Polish':     'pl',
             'Portuguese': 'pt',
             'Romanian':   'ro',
             'Russian':    'ru',
             'Spanish':    'es',
             'Serbian':    'sr',
             'Slovak':     'sk',
             'Slovenian':  'sl',
             'Swedish':    'sv',
             'Thai':       'th',
             'Turkish':    'tr',
             'Ukrainian':  'uk',
             'Vietnamese': 'vi'};

goog.register(new afrous.UnitAction({
  type : 'Translate',
  label : 'Google Translate',
  description : 'Google Translate REST API. Translates text into the languages selected.',
  inputs : [
    { name : 'text',
      label : 'Text',
      type : 'String',
      size : 'large' },
    { name : 'lang1',
      label : 'From',
      type : 'String',
      options : afrous.lang.keys(LANGS) },
    { name : 'lang2',
      label : 'To',
      type : 'String',
      options : afrous.lang.keys(LANGS) }
  ]
  ,
  execute : function(request, callback) {
    var text  = request.params['text'];
    var lang1 = request.params['lang1'];
    var lang2 = request.params['lang2'];

    lang1 = LANGS[lang1];
    lang2 = LANGS[lang2];

    if(text == null || lang1 == null || lang2 == null)
      return;

    text = text.substring(0,4999);

    var requrl = 'http://ajax.googleapis.com/ajax/services/language/translate?v=1.0&key='+apikey+
                                                                                  '&q='+encodeURIComponent(text)+
                                                                                  '&langpair='+lang1+'|'+lang2;
    afrous.ajax.jsonp.invoke(requrl, {
      onSuccess : function(ret) {
        if (ret.responseStatus=='200') {
          callback.onSuccess(ret.responseData);
        } else {
          callback.onFailure({ error : ret.responseStatus, message : ret.responseDetails });
        }
      },
      onFailure : callback.onFailure
    });
  }

}));

afrous.packages.register(goog, 'google.js');


})();

