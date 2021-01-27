new Vue({
    // root node
    el: "#app",
    // the instance state
    data: function() {
        return {
            name: null,
            password: null,
        };
    },
    methods: {
        // submit form handler
        submit: function() {
            axios.get('http://localhost:8080/login', {name, password})
        },
    },
});