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
            axios.post({name, password})
        },
    },
});