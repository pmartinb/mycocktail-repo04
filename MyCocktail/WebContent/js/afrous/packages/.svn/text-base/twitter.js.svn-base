/**
 * Services.Twitter Package
 */

(function() {

var twitter = new afrous.UnitActionPackage('Services.Twitter', {
  label : 'Twitter',
  icon : 'http://twitter.com/favicon.ico'
});

twitter.register(new afrous.UnitAction({
  type : 'PublicTimeline',
  label : 'Public Timeline',
  description : 'Returns the 20 most recent statuses from non-protected users who have set a custom user icon.',
  inputs : [
    {name : 'since_id',
      label : 'since id',
      type : 'String'}
  ]
  ,
  execute : function(request, callback) {
    var url = 'http://twitter.com/statuses/public_timeline.json?count=10';
    if (request.params['since_id']) url += '?since_id='+request.params['since_id'];
    afrous.ajax.jsonp.invoke(url, callback, {globalCallback : true});
  }

}));


twitter.register(new afrous.UnitAction({
  type : 'FriendsTimeline',
  label : 'Friends Timeline',
  description : "Returns the 20 most recent statuses posted in the last 24 hours from the authenticating user and that user's friends.", 
  inputs : [
    {name : 'id',
      label : 'twitter id',
      type : 'String'},
    {name : 'page',
      label : 'page num',
      type : 'Integer'}
  ]
  ,
  execute : function(request, callback) {
    var url = 'http://twitter.com/statuses/friends_timeline';
    url += (request.params['id'] ? '/'+request.params['id'] : '') + '.json?count=20'; 
    if (request.params['page']) url += '&page='+request.params['page'];
    afrous.ajax.jsonp.invoke(url, callback, {globalCallback : true});
  }

}));


twitter.register(new afrous.UnitAction({
  type : 'UserProfile',
  label : 'User Profile',
  description : "Returns user's profile in twitter.",
  inputs : [
    {name : 'id',
      label : 'twitter id',
      type : 'String'}
  ]
  ,
  execute : function(request, callback) {
    var url = 'http://twitter.com/statuses/user_timeline';
    url += (request.params['id'] ? '/'+request.params['id'] : '') + '.json?';
    url += 'count=1';
    afrous.ajax.jsonp.invoke(url, {
      onSuccess : function(res) {callback.onSuccess(res[0].user)},
      onFailure : function(err) {callback.onFailure(err)}
    }, {globalCallback : true});
  }

}));


twitter.register(new afrous.UnitAction({
  type : 'UserTimeline',
  label : 'User Timeline',
  description : "Returns the 20 most recent statuses posted in the last 24 hours from the authenticating user.",
  inputs : [
    {name : 'id',
      label : 'twitter id',
      type : 'String'},
    {name : 'count',
      label : 'count',
      type : 'Integer'},
    {name : 'page',
      label : 'page num',
      type : 'Integer'}
  ]
  ,
  execute : function(request, callback) {
    var url = 'http://twitter.com/statuses/user_timeline';
    url += (request.params['id'] ? '/'+request.params['id'] : '') + '.json?';
    url += 'count='+ (request.params['count'] || 20); 
    if (request.params['page']) url += '&page='+request.params['page'];
    afrous.ajax.jsonp.invoke(url, callback, {globalCallback : true});
  }

}));


twitter.register(new afrous.UnitAction({
  type : 'Friends',
  label : 'Friends',
  description : "Returns up to 100 of the authenticating user's friends who have most recently updated, each with current status inline.",
  inputs : [
    {name : 'id',
      label : 'twitter id',
      type : 'String'}
  ]
  ,
  execute : function(request, callback) {
    var url = 'http://twitter.com/statuses/friends';
    url += (request.params['id'] ? '/'+request.params['id'] : '') + '.json';
    afrous.ajax.jsonp.invoke(url, callback, {globalCallback : true});
  }

}));


twitter.register(new afrous.UnitAction({
  type : 'Followers',
  label : 'Followers',
  description : "Returns the authenticating user's followers, each with current status inline.",
  inputs : [],

  execute : function(request, callback) {
    var url = 'http://twitter.com/statuses/followers.json';
    afrous.ajax.jsonp.invoke(url, callback, {globalCallback : true});
  }

}));


twitter.register(new afrous.UnitAction({
  type : 'Favorites',
  label : 'Favorites',
  description : "Returns the 20 most recent favorite statuses for the authenticating user or user specified by the ID parameter in the requested format.",
  inputs : [
    {name : 'id',
      label : 'twitter id',
      type : 'String'},
    {name : 'page',
      label : 'page',
      type : 'Integer'}
  ]
  ,
  execute : function(request, callback) {
    var url = 'http://twitter.com/favorites';
    url += (request.params['id'] ? '/'+request.params['id'] : '') + '.json';
    if (request.params['page']) url += '&page='+request.params['page'];
    afrous.ajax.jsonp.invoke(url, callback, {globalCallback : true});
  }

}));

twitter.register(new afrous.UnitAction({
  type : 'Search',
  label : 'Search',
  description : 'Busqueda de noticias',
  inputs : [
    {name : 'valor',
      label : 'valor',
      type : 'String'}
  ]
  ,
  execute : function(request, callback) {
    var url = 'http://search.twitter.com/search.json?q=';
    var i = 0;
   


    if (request.params['valor']) url += request.params['valor'];
    afrous.ajax.jsonp.invoke(url, {
      onSuccess : function(ret) {
            var i = 0;

          for(i=0;i<ret.results.length;i++){
            var userUnique = [];
            
            
            var link = '<a href="http://www.twitter.com/'+ret.results[i].from_user+'" target="_blank">'+ret.results[i].from_user+'</a><br/>';
            ret.results[i].from_user=link;


            /*Extraer los HashTag*/
            var str = ret.results[i].text;
            var regexp = new RegExp('#[\\w\\d-_]+', 'g');
            var hashtag = [];
            str.replace(regexp, function(){
            hashtag.push(Array.prototype.slice.call(arguments, 0, -2));
            })
            var b =0;
            /*var hashUnique = afrous.lang.filter(hashtag || [], function(elem) {
                var val = hashtag ? elem[hashtag] : afrous.lang.toJSON(elem);
            if (tmp[val]) {
                return false;
            } else {
                tmp[val] = true;
            return true;
            }
             })*/
            for(b=0;b<hashtag.length;b++){
                var hashtagUser=hashtag[b].toString().replace('#','%23');
                var change ='<a href="http://twitter.com/search?q='+hashtagUser+'" target="_blank">'+hashtag[b]+'</a>';
                str = str.replace(new RegExp(hashtag[b], 'g'),change);
            }

            ret.results[i].text=str;

            str = ret.results[i].text;
            var tmp ={};
            var regexp2 = new RegExp('@[\\w\\d-_,]+', 'g');
            var user = [];
            str.replace(regexp2, function(){
            user.push(Array.prototype.slice.call(arguments, 0, -2));
            })
      
            for(b=0;b<user.length;b++){
                var change2 ='<a href="http://twitter.com/'+user[b]+'" target="_blank">'+user[b]+'</a>';
                str = str.replace(new RegExp(user[b], 'g'),change2);
                }
            ret.results[i].text=str;
            }
            
        callback.onSuccess(ret);
      },
      onFailure : callback.onFailure
    }, {globalCallback : true});
  }

}));

afrous.packages.register(twitter, 'twitter.js');

})();
