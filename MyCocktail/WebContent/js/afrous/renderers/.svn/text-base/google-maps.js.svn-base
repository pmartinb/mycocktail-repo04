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
 * Google Maps Renderer Package
 */

(function() {

var googlemaps = new afrous.UnitActionPackage('Renderer.GoogleMaps', {
  label : 'Google Maps'
});

googlemaps.MAP_TYPES = {
  NORMAL_MAP : 'Normal',
  HYBRID_MAP : 'Hibrid',
  SATELITE_TYPE_MAP : 'Satellite',
  TERRAIN_MAP : 'Terrain'
}

googlemaps.register(new afrous.RenderingUnitAction({

  type : 'GoogleMapsLocator',
  label : 'Google Maps Locator',
  description : 'Center a map in a point or location in Google Maps',
  iconCls : 'gmaps-uaction',
  inputs : [
    { name : 'placeName',
      label : 'Place Name',
      type : 'String' },
    { name : 'latitude',
      label : 'Latitude',
      type : 'Double' },
    { name : 'longitude',
      label : 'Longitude',
      type : 'Double' },
    { name : 'zoom',
      label : 'Zoom',
      type : 'Integer' },
    { name : 'width',
      label : 'Width',
      type : 'Integer' },
    { name : 'height',
      label : 'Height',
      type : 'Integer' },
    { name : 'zoomController',
      label : 'Zoom Controller',
      type : 'String',
      formElement : "CHECK_BOX" },
    { name : 'mapTypeController',
      label : 'Map Type Controller',
      type : 'String',
      formElement : "CHECK_BOX" },
    { name : 'mapType',
      label : 'Map type',
      type : 'String', 
      options : [googlemaps.MAP_TYPES.NORMAL_MAP, 
                 googlemaps.MAP_TYPES.HYBRID_MAP, 
                 googlemaps.MAP_TYPES.TERRAIN_MAP, 
                 googlemaps.MAP_TYPES.SATELITE_TYPE_MAP]}
  ],

  render : function(params, el) {

    var placeName = params['placeName'] || '';
    var longitude = params['longitude'] || '';
    var latitude  = params['latitude']  || '';
    
    if(placeName=='' && (longitude=='' && latitude==''))
      return;

    var zoom = params['zoom'] || 13;

    var width  = params['width']  || 500;
    var height = params['height'] || 500;
    
    var mapType = params['mapType'] || googlemaps.MAP_TYPES.NORMAL_MAP;
    
    var mapTypeController = false;
    mapTypeController = params['mapTypeController'] || false;
    if(mapTypeController == 'true')
      mapTypeController = true;
  
    var zoomController = false;
    zoomController = params['zoomController'] || false;
    if(zoomController == 'true')
      zoomController = true;

    var divId = 'visualization' + generateId();
    var div = afrous.dom.createElement({
      style: 'width:'+width+'px;height:'+height+'px',
      id : divId
    });
    el.appendChild(div);

    if(placeName) {
      window.f1 = function() {
        renderMapPlaceName(divId, placeName, zoom, zoomController, mapTypeController, mapType); 
      }
    } else {
      window.f1 = function() {
        renderMapPlaceLocation(divId, longitude, latitude, zoom, zoomController, mapTypeController, mapType); 
      }
    }
    
    if(!document.getElementById("script-google-maps")) {
      function loadScript() {
        var script = document.createElement("script");
        script.id = "script-google-maps";
        script.type = "text/javascript";
        script.src = "http://maps.google.com/maps/api/js?sensor=false&callback=f1";
        document.body.appendChild(script);
      }
    
      loadScript();
    } else {
      window.f1();
    }
  }

}))

function renderMapPlaceName(divName, placeName, zoom, mapTypeController, zoomController, mapType) {
  var geocoder = new google.maps.Geocoder();
  geocoder.geocode({'address': placeName}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      renderMapPlaceLocation(divName, results[0].geometry.location.lng(), results[0].geometry.location.lat(), zoom, mapTypeController, zoomController, mapType);
    } else {
      alert("Geocode was not successful for the following reason: " + status);
    }
  });
}

function renderMapPlaceLocation(divName, longitude, latitude, zoom, mapTypeController, zoomController, mapType) {
  var mapOptions = generateMapOptions(mapTypeController, mapType, zoomController, zoom);
  mapOptions.center = new google.maps.LatLng(latitude, longitude);
  
  var map = new google.maps.Map(document.getElementById(divName), mapOptions);
}

googlemaps.register(new afrous.RenderingUnitAction({

  type : 'GoogleMapsMarker',
  label : 'Google Maps Marker',
  description : 'Positionate locations with labels in a map with Google Maps',
  iconCls : 'gmaps-uaction',
  inputs : [
    { name : 'records',
      label : 'Input Records',
      type : 'Object[]' },
    { name : 'labelField',
      label : 'Label Field',
      type : 'String',
      options : [] },
    { name : 'valueField',
      label : 'Address Field',
      type : 'String',
      options : [] },
    { name : 'width',
      label : 'Width',
      type : 'Integer' },
    { name : 'height',
      label : 'Height',
      type : 'Integer' },
    { name : 'zoomController',
      label : 'Zoom Controller',
      type : 'String',
      formElement : "CHECK_BOX" },
    { name : 'mapTypeController',
      label : 'Map Type Controller',
      type : 'String',
      formElement : "CHECK_BOX" },
    { name : 'mapType',
      label : 'Map type',
      type : 'String', 
      options : [googlemaps.MAP_TYPES.NORMAL_MAP, 
                 googlemaps.MAP_TYPES.HYBRID_MAP, 
                 googlemaps.MAP_TYPES.TERRAIN_MAP, 
                 googlemaps.MAP_TYPES.SATELITE_TYPE_MAP]}
  ],

  render : function(params, el) {

    var records = params['records'];
    if (!records) 
      return;
    var labelField = params['labelField'];
    var valueField = params['valueField'];
    
    var width  = params['width']  || 500;
    var height = params['height'] || 200;
    
    var mapType = params['mapType'] || googlemaps.MAP_TYPES.NORMAL_MAP;
    
    var mapTypeController = false;
    mapTypeController = params['mapTypeController'] || false;
    if(mapTypeController == 'true')
      mapTypeController = true;
  
    var zoomController = false;
    zoomController = params['zoomController'] || false;
    if(zoomController == 'true')
      zoomController = true;
    
    var divId = 'visualization' + generateId();
    var div = afrous.dom.createElement({
      style: 'width:'+width+'px;height:'+height+'px',
      id : divId
    });
    el.appendChild(div);
    
    window.f1 = function() {
      renderMapWithMarkers(divId, records, width, height, labelField, valueField, mapTypeController, zoomController, mapType);
    }
    
    if(!document.getElementById("script-google-maps")) {
      function loadScript() {
        var script = document.createElement("script");
        script.id = "script-google-maps";
        script.type = "text/javascript";
        script.src = "http://maps.google.com/maps/api/js?sensor=false&callback=f1";
        document.body.appendChild(script);
      }
    
      loadScript();
    } else {
      window.f1();
    }
  }

}))

function renderMapWithMarkers(divId, records, width, height, labelField, valueField, mapTypeController, zoomController, mapType) {

  var dataset = [];
  var markers = [];
  
  afrous.lang.forEach(records, function(r, i) {
    var label = r[labelField] || i;
    var location = afrous.lang.cast('String', r[valueField] || r);
    dataset.push({location: location, label: label});
  })
  
  function drawAllPoints(map){
    var points = [];
    for(var i=0; i<dataset.length; i++)
    {
      var rep = false;
      for(var j=i+1; j<dataset.length; j++)
      {
        if(dataset[i]['location'] == dataset[j]['location'] && dataset[i]['label'] != dataset[j]['label'])
        {
          dataset[j]['label'] = dataset[i]['label'] + '<br>' + dataset[j]['label'];
          rep = true;
          break;
        }
      }
      if(!rep)
        points.push(dataset[i]);
    }
    dataset = points;
    afrous.lang.forEach(dataset, function(point, i) {
      var label = null
      if (point['label'] instanceof afrous.Renderer) {
        var el = afrous.dom.createElement();
        point['label'].render(el);
        label = el.innerHTML;
        label = label.replace(new RegExp('"','g'), '\'')
                     .replace(new RegExp('script>','g'), 'scr"+"ipt>');
      } else {
        label = point['label'] + "";
      }
      label = label.replace(new RegExp('\n','g'), '<br />')
                   .replace(new RegExp('\r','g'), '<br />')
                   .replace(new RegExp('\t','g'), '    ');
                                   
      findLocationAndAddMarker(map, point['location'].replace(/(\\|\")/g, '\\$1'),label);
    });
  }
  
  
  function findLocationAndAddMarker(map, address, label) {
    if(isLatLng(address)) {   
      var p = address.split(",");
      var point = new google.maps.LatLng(p[0],p[1]);
      addMarker(map, point, label);
      markers.push(point);
      setCenter(map,markers);
    } else {
      var geocoder = new google.maps.Geocoder();
      geocoder.geocode({'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          var point = results[0].geometry.location;
          addMarker(map, point, label);
          markers.push(point);
          setCenter(map,markers);
        } else {
          alert("Geocode was not successful for the following reason: " + status);
        }
      }); 
    }
  }
  
  function isLatLng(latLng) {
      if(/^(\+|-)?[0-9]{1,2}(\.[0-9]+)?,(\+|-)?[0-9]{1,3}(\.[0-9]+)?$/.test(latLng)) {
          var p = latLng.split(",");
          if(-90 <= p[0] && p[0] <= 90 && -180 <= p[1] && p[1] <= 180) {
              return true;
          }
      }
      return false;
  }

  function addMarker(map, point, label) {
    var marker = new google.maps.Marker({
        position: point,
        map: map
    });
    var infowindow = new google.maps.InfoWindow({ 
        content: '<div style="color:black">' + label + '</div>',
        position: point
    });
    google.maps.event.addListener(marker, 'click', function(event) {
      infowindow.open(map);
    });
  }
  
  function adjustCenter(map,points,point,bounds){
    if(bounds.north < point.lat())
      bounds.north = point.lat();
    if(bounds.south > point.lat())
      bounds.south = point.lat();
    if(bounds.east < point.lng())
      bounds.east = point.lng();
    if(bounds.west > point.lng())
      bounds.west = point.lng();
    
    var mapBounds = new google.maps.LatLngBounds(new google.maps.LatLng(bounds.south,bounds.west), 
                                                 new google.maps.LatLng(bounds.north,bounds.east));
    map.fitBounds(mapBounds);
    if(points.length == 1) {
      var zoom = 8;
      map.setCenter(mapBounds.getCenter(), zoom);
    }
  }
  
  function setCenter(map,pointArray){
    var north =  -90;
    var south =   90;
    var east  = -180;
    var west  =  180;
    
    afrous.lang.forEach(pointArray, function(point, i) {
      if(north < point.lat())
        north = point.lat();
      if(south > point.lat())
        south = point.lat();
      if(east  < point.lng())
        east  = point.lng();
      if(west  > point.lng())
        west  = point.lng();
    });
    
    var bounds = new google.maps.LatLngBounds(new google.maps.LatLng(south,west), new google.maps.LatLng(north,east));
    map.fitBounds(bounds);
    map.setCenter(bounds.getCenter());
    if(pointArray.length == 1) {
      map.setZoom(8);     
    }
  }
  
  var mapOptions = generateMapOptions(mapTypeController, mapType, zoomController, null);
  mapOptions.center = new google.maps.LatLng(0, 0);
  
  var map = new google.maps.Map(document.getElementById(divId), mapOptions);
  drawAllPoints(map);
}

function generateMapOptions(mapTypeController, mapType, zoomController, zoom) {
  var mapOptions = {};
  mapOptions.zoomControl = zoomController;
  if (zoom) {
    mapOptions.zoom = zoom;
  }
  mapOptions.mapTypeControl = mapTypeController;
  mapOptions.mapTypeId = getMapTypeId(mapType);
  return mapOptions;
}

function getMapTypeId(mapType) {
  if(mapType == googlemaps.MAP_TYPES.SATELITE_TYPE_MAP)
    return google.maps.MapTypeId.SATELLITE;
  if(mapType == googlemaps.MAP_TYPES.HYBRID_MAP)
    return google.maps.MapTypeId.HYBRID;
  if(mapType == googlemaps.MAP_TYPES.TERRAIN_MAP)
    return google.maps.MapTypeId.TERRAIN;
  return google.maps.MapTypeId.ROADMAP;
}

function generateId()
{
  return 'googlemapsDiv'+getRandomInt(0,5000)+'a'
                        +getRandomInt(0,5000)+'b'
                        +getRandomInt(0,5000)+'c'
                        +getRandomInt(0,5000);
}

function getRandomInt(min, max)
{
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

// if in afrous editor
if (afrous.editor) {
  afrous.packages.loadScript(afrous.packages.scriptBaseURL + '/renderers/render-widget.js');
}

afrous.packages.register(googlemaps, 'google-maps.js');

})();
