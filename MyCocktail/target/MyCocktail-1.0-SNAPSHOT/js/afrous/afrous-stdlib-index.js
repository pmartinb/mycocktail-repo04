(function() {

var p = afrous.packages;
var u = p.scriptBaseURL;

p.loadScript(u+'/afrous-package.js');
p.loadScript(u+'/operators/ajax-operators.js');
p.loadScript(u+'/afrous-scrape.js');
p.loadScript(u+'/packages/delicious.js');
//p.loadScript(u+'/packages/device.js');
p.loadScript(u+'/packages/yahoo.js');
p.loadScript(u+'/packages/google.js');
p.loadScript(u+'/packages/google-data.js');
p.loadScript(u+'/packages/flickr.js');
p.loadScript(u+'/packages/twitter.js');
p.loadScript(u+'/packages/amazon.js');
p.loadScript(u+'/packages/youtube.js');
p.loadScript(u+'/packages/omelette.js');
p.loadScript(u+'/packages/freebase.js');
p.loadScript(u+'/packages/musiteca.js');
p.loadScript(u+'/packages/ecm_systems.js');
p.loadScript(u+'/packages/facebook.js');
//p.loadScript(u+'/packages/seo_plagarism.js');

if ((navigator.language || navigator.userLanguage || '').indexOf('ja')==0) {
  p.loadScript(u+'/packages/hatena.js');
  p.loadScript(u+'/packages/livedoor.js');
  p.loadScript(u+'/packages/pathtraq.js');
}

p.loadScript(u+'/renderers/advanced-renders.js');
p.loadScript(u+'/renderers/plotr-afrous.js');
//p.loadScript(u+'/renderers/schart.js');
p.loadScript(u+'/renderers/google-visualization.js');
p.loadScript(u+'/renderers/google-maps.js');
p.loadScript(u+'/renderers/smile-widgets.js');
p.loadScript(u+'/renderers/widgets.js');
p.loadScript(u+'/renderers/fragments/fragments.js');
p.loadScript(u+'/renderers/telcoservices.js');

//---------custom scripts
p.loadScript(u+'/operators/date-operators.js');
//p.loadScript(u+'/operators/calc-operators.js');
p.loadScript(u+'/operators/dpipes-operators.js');
p.loadScript(u+'/operators/atompub-operators.js');

})();
