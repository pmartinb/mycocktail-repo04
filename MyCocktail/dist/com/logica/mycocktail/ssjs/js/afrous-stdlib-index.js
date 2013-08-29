(function() {

var p = afrous.packages;
var u = p.scriptBaseURL;

p.loadScript(u+'/afrous-scrape.js');
//p.loadScript(u+'/packages/delicious.js');
p.loadScript(u+'/packages/device.js');
p.loadScript(u+'/packages/yahoo.js');
p.loadScript(u+'/packages/google.js');
p.loadScript(u+'/packages/flickr.js');
p.loadScript(u+'/packages/twitter.js');
p.loadScript(u+'/packages/amazon.js');
p.loadScript(u+'/packages/youtube.js');
p.loadScript(u+'/packages/freebase.js');
//p.loadScript(u+'/packages/musiteca.js');
p.loadScript(u+'/packages/ecm_systems.js');
p.loadScript(u+'/packages/facebook.js');
//p.loadScript(u+'/packages/seo_plagarism.js');

if ((navigator.language || navigator.userLanguage || '').indexOf('ja')==0) {
  p.loadScript(u+'/packages/hatena.js');
  p.loadScript(u+'/packages/livedoor.js');
  p.loadScript(u+'/packages/pathtraq.js');
}

//---------custom scripts
p.loadScript(u+'/operators/date-operators.js');
p.loadScript(u+'/operators/calc-operators.js');
//p.loadScript(u+'/operators/dpipes-operators.js');
//p.loadScript(u+'/operators/atompub-operators.js');

})();
