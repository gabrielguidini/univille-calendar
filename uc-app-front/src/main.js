import "./assets/main.css";

import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import cors from "cors";

import "vuetify/styles";
import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
import * as directives from "vuetify/directives";
import store from './store'

const vuetify = createVuetify({
  components,
  directives,
});

const app = createApp(App).use(store);

app.use(router);
app.use(vuetify);

app.mount("#app");
