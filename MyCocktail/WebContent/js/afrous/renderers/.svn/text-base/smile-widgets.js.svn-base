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
 * Timeline render
 */

(function() {

var smileWidgets = new afrous.UnitActionPackage('Renderer.SmileWidgets', {
  label : 'Smile Widgets'
});

smileWidgets.register(new afrous.RenderingUnitAction({

  type : 'Timeline',
  label : 'Timeline',
  description : 'Timeline',
  iconCls : 'timeline-render-uaction',
  inputs : [
    { name : 'records',
      label : 'Input Records',
      type : 'Object[]' },
    { name : 'titleField',
      label : 'Title Field',
      type : 'String',
      options : [] },
    { name : 'descriptionField',
      label : 'Description Field',
      type : 'String',
      options : [] },
    { name : 'initialDateField',
      label : 'Initial Date Field',
      type : 'String',
      options : [] },
    { name : 'finalDateField',
      label : 'Final Date Field',
      type : 'String',
      options : [] },
    { name : 'monthPixels',
      label : 'Month Pixels',
      type : 'Integer' },
    { name : 'yearPixels',
      label : 'Year Pixels',
      type : 'Integer' },
    { name : 'width',
      label : 'Width',
      type : 'Integer' },
    { name : 'height',
      label : 'Height',
      type : 'Integer' }
  ],

  render : function(params, el) {

    var records = params['records'];
    if (!records) 
      return;
    var titleField       = params['titleField'];
    var descriptionField = params['descriptionField'];
    var initialDate      = params['initialDateField'];
    var finalDate        = params['finalDateField'];
    var monthPixels      = params['monthPixels'] || 100;
    var yearPixels       = params['yearPixels']  || 200;
    var width            = params['width']  || 500;
    var height           = params['height'] || 250;

    var events = [];
    afrous.lang.forEach(records, function(r, i) {
      var title = r[titleField]       || i;
      var desc  = r[descriptionField] || i;
      var start = afrous.lang.cast('String', r[initialDate] || r);
      var end   = afrous.lang.cast('String', r[finalDate]   || r);
      events.push({start:start, end:end, durationEvent:true, title: title, description: desc})
    });

    var json={
      'dateTimeFormat': 'iso8601',
      'events': events
    }

    el.innerHTML = '<div id="my-timeline" style="border: 1px solid rgb(170, 170, 170); width:'+width+'px; height:'+height+'px;"></div>';

    var eventSource = new Timeline.DefaultEventSource();
    var bandInfos = [
      Timeline.createBandInfo({
         eventSource:    eventSource,
         date:           new Date(),
         width:          "70%",
         intervalUnit:   Timeline.DateTime.MONTH,
         intervalPixels: monthPixels
      }),
      Timeline.createBandInfo({
         eventSource:    eventSource,
         date:           new Date(),
         width:          "30%",
         intervalUnit:   Timeline.DateTime.YEAR,
         intervalPixels: yearPixels
      })
    ];
    bandInfos[1].syncWith = 0;
    bandInfos[1].highlight = true;

    Timeline.create(document.getElementById('my-timeline'), bandInfos);
    eventSource.loadJSON(json, document.location.href);
  }

}))

// if in afrous editor
if (afrous.editor) {
  afrous.packages.loadScript(afrous.packages.scriptBaseURL + '/renderers/render-widget.js');
}

afrous.packages.register(smileWidgets, 'smile-widgets.js');

})();

