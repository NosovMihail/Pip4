// var X = new Vue({
//     el: '#X',
//     data: {
//         user:''
//     }
// });
var messageApi = Vue.resource('/point');
var request = Vue.resource('/points');
Vue.component('send', {
    props: ['results'],
    data: function() {
        return {
            X: '',
            Y: '',
            R: ''
        }
    },
    template:
        '<div>'+
        '<input type="button" value="Отправить" @click="save" />'+
        '</div>',
    methods: {
        save: function() {
            var message = {x: this.x, y: this.y, r: this.r};
            messageApi.get(message);
            request.get().then(result => result.json().then(data => data.forEach(ans => this.results.push(ans))));
        }
    }
});
var post = new Vue({
   el:"#post",
   template: '<send/>'
});
var res = new Vue({
    el:"#res",
    template: '<td v-for="result in res" :key=res>{{res}}</td>',
    data:{
        results: []
    }
})
var app = new Vue({
    // root node
    el: "#app",
    //template: '<login-form />',
    methods: {
    },
});