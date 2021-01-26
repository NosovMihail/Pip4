var messageApi = Vue.resource('/login')

Vue.component('login-form', {
    props: ['messages'],
    data: function() {
        return {
            name: '',
            password: '',
        }
    },
    template:
        '<div>'+
    '<form class="vue-form" @submit="">'+
    '<legend>Vue Contact Form</legend>'+
    '<div>'+
    '<label class="label" for="name">Name</label>'+
    '<input type="text" name="name" id="name" required="" v-model="name">'+
    '</div>'+
    '<div>'+
    '<label class="label" for="password">Password</label>'+
    '<input type="password" name="password" id="password" required="" v-model="password">'+
    '</div>'+
    '<div>'+
    '<input type="button" value="Вход" @click="save" />'+
    '</div>'+
    '</form>'+

    '<div class="debug">'+
    '<pre><code>{{ $data }}</code></pre>'+
        '<div>'+
    '</div>' //+
        //
        // '<div>' +
        // '<input type="text" placeholder="x" v-model="x" />' +
        // '<input type="text" placeholder="y" v-model="y" />' +
        // '<input type="text" placeholder="r" v-model="r" />' +
        // '<input type="button" value="Вход" @click="save" />' +
        // '</div>',
        ,
    methods: {
        save: function() {
            var message = {name: this.name, password: this.password};
            messageApi.get(message).then(result => result.json().then(data => {
                //this.messages.push(data);
                //this.text = '';

                window.location.href = '/point'
            })
            )

        }
    }
});
var app = new Vue({
    // root node
    el: "#app",
    // the instance state
    data: function() {
        return {
            name: null,
            password: null,
        };
    },
    template: '<login-form />',
    methods: {
        // submit form handler
        submit: function() {
            x = name;
            y = password;
            axios.get('http://localhost:8080/point', {x, y, r:1}) //'http://localhost:8080/login'
        },
    },
});