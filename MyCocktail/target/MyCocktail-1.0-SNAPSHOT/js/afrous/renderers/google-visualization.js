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
 * Google Visualization Renderer Package
 */

(function() {

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

var googleVisualization = new afrous.UnitActionPackage('Renderer.GoogleVisualization', {
  label : 'Google Interactive Chart Renderer'
});

googleVisualization.register(new afrous.RenderingUnitAction({
  type : 'GoogleChart',
  label : 'Google Chart',
  description : 'Create a chart from given record list.',
  iconCls : 'google-chart-uaction',
  inputs : [
    {name : 'records',
      label : 'Input Records',
      type : 'Object[]'},
    {name : 'type',
      label : 'Chart Type',
      type : 'String',
      options : [ CHART_TYPE.ANNOTATED_TIMELINE_CHART,
                  CHART_TYPE.AREA_CHART,   CHART_TYPE.BAR_CHART,
                  CHART_TYPE.COLUMN_CHART, CHART_TYPE.GEO_MAP,
                  CHART_TYPE.LINE_CHART,   CHART_TYPE.PIE_CHART ]},
    {name : 'title',
      label : 'Chart Title',
      type : 'String'},
    {name : 'hAxis',
      label : 'Horiz. Axis Title',
      type : 'String'},
    {name : 'vAxis',
      label : 'Vert. Axis Title',
      type : 'String'},
    {name : 'width',
      label : 'Width',
      type : 'Integer'},
    {name : 'height',
      label : 'Height',
      type : 'Integer'},
    {name : 'labelField',
      label : 'Label Field',
      type : 'String',
      options : []},
    {name : 'valueFields',
      label : 'Number of Value Fields',
      type : 'Integer',
      options : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]}
  ],

  render : function(params, el) {

    var type = params['type'];

    var records = params['records'];
    if (!records) return;
    var labelField = params['labelField'];
    var valueFields = [];
    for (var i=1; i<=10; i++) {
      if (params['valueField'+i]) valueFields.push(params['valueField'+i]);
      else break;
    }
    var width  = params['width']  || 500;
    var height = params['height'] || 300;
    var colorScheme = params['colorScheme'] || 'blue';
    
    var title = params['title'] || null;
    var vAxis = params['vAxis'] || null;
    var hAxis = params['hAxis'] || null;

    var options = {};
    options.width  = width;
    options.height = height;
    if (title)
      options.title = title;
    if (vAxis)
      options.vAxis = {title: vAxis};
    if (hAxis)
      options.hAxis = {title: hAxis};

    var divId = 'visualization' + generateId();
    var div = afrous.dom.createElement({
      tagName : 'div',
      style : 'width:'+width+'px;height:'+height+'px;',
      id : divId
    });
    el.appendChild(div);

    renderChart(type, records, labelField, valueFields, options, divId)
  }

}))

googleVisualization.register(new afrous.RenderingUnitAction({
  type : 'Table',
  label : 'Table Renderer',
  description : 'Create Table from given record list.',
  iconCls : 'table-render-uaction',
  inputs : [
    {name : 'records',
      label : 'Input Records',
      type : 'Object[]'},
    {name : 'width',
      label : 'Width',
      type : 'Integer'},
    {name : 'height',
      label : 'Height',
      type : 'Integer'},
    {name : 'pagination',
      label : 'Pagination',
      type : 'String',
      options : ['None', '5', '10', '15', '20', '25', '50', '100']},
    {name : 'columns',
      label : 'Number of Columns',
      type : 'Integer',
      options : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]}
  ],

  render : function(params, el) {

    var records = params['records'];
    if (!records) return;
    var valueFields = [];
    for (var i=1; i<=10; i++) {
      if (params['col'+i]) valueFields.push(params['col'+i]);
      else break;
    }

    var width  = params['width']  || null;
    var height = params['height'] || null;

    var pagination = params['pagination'] || null;

    var options = {};
    if (width)
      options.width  = width;
    if (height)
      options.height = height;
    if (pagination && pagination != 'None') {
      options['page'] = 'enable';
      options['pageSize'] = parseInt(pagination);
      options['pagingSymbols'] = {prev: 'prev', next: 'next'};
      options['pagingButtonsConfiguration'] = 'auto';
    }
    options['allowHtml'] = true;

    var divId = 'visualization' + generateId();
    var div = afrous.dom.createElement({
      tagName : 'div',
      id : divId
    });
    el.appendChild(div);

    renderTable(records, valueFields, options, divId)
  }

}))

function renderChart(type, records, labelField, valueFields, options, divId) {
  var data = null;
  if (CHART_TYPE.ANNOTATED_TIMELINE_CHART == type)
    data = generateBasicDataSet(records, labelField, 'date', valueFields);
  else
    data = generateBasicDataSet(records, labelField, 'string', valueFields);

  var div = document.getElementById(divId);

  var chart = null;
  switch(type) {
    case CHART_TYPE.AREA_CHART:
      chart = new google.visualization.AreaChart(div);
      break;
    case CHART_TYPE.BAR_CHART:
      chart = new google.visualization.BarChart(div);
      break;
    case CHART_TYPE.LINE_CHART:
      chart = new google.visualization.LineChart(div);
      break;
    case CHART_TYPE.PIE_CHART:
      chart = new google.visualization.PieChart(div);
      break;
    case CHART_TYPE.GEO_MAP:
      chart = new google.visualization.GeoMap(div);
      break;
    case CHART_TYPE.ANNOTATED_TIMELINE_CHART:
      chart = new google.visualization.AnnotatedTimeLine(div);
      break;
    case CHART_TYPE.COLUMN_CHART:
    default:
      chart = new google.visualization.ColumnChart(div);
      break;
  }

  // Create and draw the visualization.
  chart.draw(data, options);
}

function generateBasicDataSet(records, labelField, labelFieldType, valueFields) {
    
  var labelArray = [];
  afrous.lang.forEach(records, function(r, i) {
    var label = r[labelField]
    if(afrous.lang.isObject(label))
    {
      if(label.myCocktailName)
        label = label.myCocktailName;
      else if(label.name)
        label = label.name;
      else if(label.title)
        label = label.title;
    }
    labelArray.push(label);
  });


  var data = new google.visualization.DataTable();
  var label = labelField;
  if (label)
    label = label[0].toUpperCase() + label.substr(1);
  data.addColumn(labelFieldType, label);
  for (var j = 0; j < valueFields.length; ++j) {
    label = valueFields[j].toString();
    if (label)
      label = label[0].toUpperCase() + label.substr(1);
    data.addColumn('number', label);
  }

  data.addRows(records.length);
  for (j = 0; j < labelArray.length; ++j) {
    var lab = labelArray[j];
    if (labelFieldType == 'string') {
        lab = lab.toString();
    }
    data.setValue(j, 0, lab);
  }

  afrous.lang.forEach(records, function(r, j) {
    for(var i=0; i<valueFields.length; i++) {
      data.setValue(j, i+1, afrous.lang.cast('float', r[valueFields[i]]));
    }
  });

  return data;
}

function renderTable(records, valueFields, options, divId) {
  var data = generateTableDataSet(records, valueFields);

  var div = document.getElementById(divId);

  var chart = new google.visualization.Table(div);
  chart.draw(data, options);
}

function generateTableDataSet(records, valueFields) {

  var data = new google.visualization.DataTable();
  for (var j = 0; j < valueFields.length; ++j) {
    var colName = valueFields[j].toString();
    colName = colName[0].toUpperCase() + colName.substr(1);
    data.addColumn('string', colName);
  }

  data.addRows(records.length);

  afrous.lang.forEach(records, function(r, j) {
    for(var i=0; i<valueFields.length; i++) {
      var value = r[valueFields[i]];
      if (value)
        value = value.toString();
      data.setCell(j, i, value);
    }
  });

  return data;
}

function generateId()
{
  return 'chartDiv'+getRandomInt(0,5000)+'a'
                   +getRandomInt(0,5000)+'b'
                   +getRandomInt(0,5000)+'c'
                   +getRandomInt(0,5000);
}

function getRandomInt(min, max)
{
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

afrous.packages.register(googleVisualization, 'google-visualization.js');


// if in afrous editor
if (afrous.editor) {
  afrous.packages.loadScript(afrous.packages.scriptBaseURL + '/renderers/render-widget.js');
}


})();

