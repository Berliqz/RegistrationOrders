function AppWidgetset(){var O='bootstrap',P='begin',Q='gwt.codesvr.AppWidgetset=',R='gwt.codesvr=',S='AppWidgetset',T='startup',U='DUMMY',V=0,W=1,X='iframe',Y='position:absolute; width:0; height:0; border:none; left: -1000px;',Z=' top: -1000px;',$='CSS1Compat',_='<!doctype html>',ab='',bb='<html><head><\/head><body><\/body><\/html>',cb='undefined',db='readystatechange',eb=10,fb='Chrome',gb='eval("',hb='");',ib='script',jb='javascript',kb='moduleStartup',lb='moduleRequested',mb='Failed to load ',nb='head',ob='meta',pb='name',qb='AppWidgetset::',rb='::',sb='gwt:property',tb='content',ub='=',vb='gwt:onPropertyErrorFn',wb='Bad handler "',xb='" for "gwt:onPropertyErrorFn"',yb='gwt:onLoadErrorFn',zb='" for "gwt:onLoadErrorFn"',Ab='#',Bb='?',Cb='/',Db='img',Eb='clear.cache.gif',Fb='baseUrl',Gb='AppWidgetset.nocache.js',Hb='base',Ib='//',Jb='modernie',Kb='MSIE',Lb='Trident',Mb='yes',Nb='none',Ob='user.agent',Pb='webkit',Qb='safari',Rb='msie',Sb=11,Tb='ie10',Ub=9,Vb='ie9',Wb=8,Xb='ie8',Yb='gecko',Zb='gecko1_8',$b=2,_b=3,ac=4,bc='selectingPermutation',cc='AppWidgetset.devmode.js',dc='E23C632AC073FD0CC2980783093B311A',ec=':1',fc=':2',gc=':',hc='.cache.js',ic='loadExternalRefs',jc='end',kc='http:',lc='file:',mc='_gwt_dummy_',nc='__gwtDevModeHook:AppWidgetset',oc='Ignoring non-whitelisted Dev Mode URL: ',pc=':moduleBase';var o=window;var p=document;r(O,P);function q(){var a=o.location.search;return a.indexOf(Q)!=-1||a.indexOf(R)!=-1}
function r(a,b){if(o.__gwtStatsEvent){o.__gwtStatsEvent({moduleName:S,sessionId:o.__gwtStatsSessionId,subSystem:T,evtGroup:a,millis:(new Date).getTime(),type:b})}}
AppWidgetset.__sendStats=r;AppWidgetset.__moduleName=S;AppWidgetset.__errFn=null;AppWidgetset.__moduleBase=U;AppWidgetset.__softPermutationId=V;AppWidgetset.__computePropValue=null;AppWidgetset.__getPropMap=null;AppWidgetset.__installRunAsyncCode=function(){};AppWidgetset.__gwtStartLoadingFragment=function(){return null};AppWidgetset.__gwt_isKnownPropertyValue=function(){return false};AppWidgetset.__gwt_getMetaProperty=function(){return null};var s=null;var t=o.__gwt_activeModules=o.__gwt_activeModules||{};t[S]={moduleName:S};AppWidgetset.__moduleStartupDone=function(e){var f=t[S].bindings;t[S].bindings=function(){var a=f?f():{};var b=e[AppWidgetset.__softPermutationId];for(var c=V;c<b.length;c++){var d=b[c];a[d[V]]=d[W]}return a}};var u;function v(){w();return u}
function w(){if(u){return}var a=p.createElement(X);a.id=S;a.style.cssText=Y+Z;a.tabIndex=-1;p.body.appendChild(a);u=a.contentWindow.document;u.open();var b=document.compatMode==$?_:ab;u.write(b+bb);u.close()}
function A(k){function l(a){function b(){if(typeof p.readyState==cb){return typeof p.body!=cb&&p.body!=null}return /loaded|complete/.test(p.readyState)}
var c=b();if(c){a();return}function d(){if(!c){if(!b()){return}c=true;a();if(p.removeEventListener){p.removeEventListener(db,d,false)}if(e){clearInterval(e)}}}
if(p.addEventListener){p.addEventListener(db,d,false)}var e=setInterval(function(){d()},eb)}
function m(c){function d(a,b){a.removeChild(b)}
var e=v();var f=e.body;var g;if(navigator.userAgent.indexOf(fb)>-1&&window.JSON){var h=e.createDocumentFragment();h.appendChild(e.createTextNode(gb));for(var i=V;i<c.length;i++){var j=window.JSON.stringify(c[i]);h.appendChild(e.createTextNode(j.substring(W,j.length-W)))}h.appendChild(e.createTextNode(hb));g=e.createElement(ib);g.language=jb;g.appendChild(h);f.appendChild(g);d(f,g)}else{for(var i=V;i<c.length;i++){g=e.createElement(ib);g.language=jb;g.text=c[i];f.appendChild(g);d(f,g)}}}
AppWidgetset.onScriptDownloaded=function(a){l(function(){m(a)})};r(kb,lb);var n=p.createElement(ib);n.src=k;if(AppWidgetset.__errFn){n.onerror=function(){AppWidgetset.__errFn(S,new Error(mb+code))}}p.getElementsByTagName(nb)[V].appendChild(n)}
AppWidgetset.__startLoadingFragment=function(a){return D(a)};AppWidgetset.__installRunAsyncCode=function(a){var b=v();var c=b.body;var d=b.createElement(ib);d.language=jb;d.text=a;c.appendChild(d);c.removeChild(d)};function B(){var c={};var d;var e;var f=p.getElementsByTagName(ob);for(var g=V,h=f.length;g<h;++g){var i=f[g],j=i.getAttribute(pb),k;if(j){j=j.replace(qb,ab);if(j.indexOf(rb)>=V){continue}if(j==sb){k=i.getAttribute(tb);if(k){var l,m=k.indexOf(ub);if(m>=V){j=k.substring(V,m);l=k.substring(m+W)}else{j=k;l=ab}c[j]=l}}else if(j==vb){k=i.getAttribute(tb);if(k){try{d=eval(k)}catch(a){alert(wb+k+xb)}}}else if(j==yb){k=i.getAttribute(tb);if(k){try{e=eval(k)}catch(a){alert(wb+k+zb)}}}}}__gwt_getMetaProperty=function(a){var b=c[a];return b==null?null:b};s=d;AppWidgetset.__errFn=e}
function C(){function e(a){var b=a.lastIndexOf(Ab);if(b==-1){b=a.length}var c=a.indexOf(Bb);if(c==-1){c=a.length}var d=a.lastIndexOf(Cb,Math.min(c,b));return d>=V?a.substring(V,d+W):ab}
function f(a){if(a.match(/^\w+:\/\//)){}else{var b=p.createElement(Db);b.src=a+Eb;a=e(b.src)}return a}
function g(){var a=__gwt_getMetaProperty(Fb);if(a!=null){return a}return ab}
function h(){var a=p.getElementsByTagName(ib);for(var b=V;b<a.length;++b){if(a[b].src.indexOf(Gb)!=-1){return e(a[b].src)}}return ab}
function i(){var a=p.getElementsByTagName(Hb);if(a.length>V){return a[a.length-W].href}return ab}
function j(){var a=p.location;return a.href==a.protocol+Ib+a.host+a.pathname+a.search+a.hash}
var k=g();if(k==ab){k=h()}if(k==ab){k=i()}if(k==ab&&j()){k=e(p.location.href)}k=f(k);return k}
function D(a){if(a.match(/^\//)){return a}if(a.match(/^[a-zA-Z]+:\/\//)){return a}return AppWidgetset.__moduleBase+a}
function F(){var f=[];var g=V;function h(a,b){var c=f;for(var d=V,e=a.length-W;d<e;++d){c=c[a[d]]||(c[a[d]]=[])}c[a[e]]=b}
var i=[];var j=[];function k(a){var b=j[a](),c=i[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(s){s(a,d,b)}throw null}
j[Jb]=function(){{var a=o.navigator.userAgent;if(a.indexOf(Kb)==-1&&a.indexOf(Lb)!=-1){return Mb}return Nb}};i[Jb]={'none':V,'yes':W};j[Ob]=function(){var a=navigator.userAgent.toLowerCase();var b=p.documentMode;if(function(){return a.indexOf(Pb)!=-1}())return Qb;if(function(){return a.indexOf(Rb)!=-1&&(b>=eb&&b<Sb)}())return Tb;if(function(){return a.indexOf(Rb)!=-1&&(b>=Ub&&b<Sb)}())return Vb;if(function(){return a.indexOf(Rb)!=-1&&(b>=Wb&&b<Sb)}())return Xb;if(function(){return a.indexOf(Yb)!=-1||b>=Sb}())return Zb;return Qb};i[Ob]={'gecko1_8':V,'ie10':W,'ie8':$b,'ie9':_b,'safari':ac};__gwt_isKnownPropertyValue=function(a,b){return b in i[a]};AppWidgetset.__getPropMap=function(){var a={};for(var b in i){if(i.hasOwnProperty(b)){a[b]=k(b)}}return a};AppWidgetset.__computePropValue=k;o.__gwt_activeModules[S].bindings=AppWidgetset.__getPropMap;r(O,bc);if(q()){return D(cc)}var l;try{h([Nb,Zb],dc);h([Mb,Zb],dc+ec);h([Nb,Qb],dc+fc);l=f[k(Jb)][k(Ob)];var m=l.indexOf(gc);if(m!=-1){g=parseInt(l.substring(m+W),eb);l=l.substring(V,m)}}catch(a){}AppWidgetset.__softPermutationId=g;return D(l+hc)}
function G(){if(!o.__gwt_stylesLoaded){o.__gwt_stylesLoaded={}}r(ic,P);r(ic,jc)}
B();AppWidgetset.__moduleBase=C();t[S].moduleBase=AppWidgetset.__moduleBase;var H=F();if(o){var I=!!(o.location.protocol==kc||o.location.protocol==lc);o.__gwt_activeModules[S].canRedirect=I;function J(){var b=mc;try{o.sessionStorage.setItem(b,b);o.sessionStorage.removeItem(b);return true}catch(a){return false}}
if(I&&J()){var K=nc;var L=o.sessionStorage[K];if(!/^http:\/\/(localhost|127\.0\.0\.1)(:\d+)?\/.*$/.test(L)){if(L&&(window.console&&console.log)){console.log(oc+L)}L=ab}if(L&&!o[K]){o[K]=true;o[K+pc]=C();var M=p.createElement(ib);M.src=L;var N=p.getElementsByTagName(nb)[V];N.insertBefore(M,N.firstElementChild||N.children[V]);return false}}}G();r(O,jc);A(H);return true}
AppWidgetset.succeeded=AppWidgetset();