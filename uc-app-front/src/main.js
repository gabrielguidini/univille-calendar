import "./assets/main.css";

import { createApp } from "vue";
import mitt from "mitt";
import App from "./App.vue";
import router from "./router";

import "vuetify/styles";
import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
import * as directives from "vuetify/directives";
import store from "./store";

const emitter = mitt();

const vuetify = createVuetify({
 components,
 directives,
});

const app = createApp(App).use(store);

app.use(router);
app.use(vuetify);
app.config.globalProperties.emitter = emitter;

app.mount("#app");
