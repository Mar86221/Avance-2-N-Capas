import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import router from '../src/routes/router';
import { VTimePicker } from 'vuetify/labs/components'
import { VNumberInput } from 'vuetify/labs/components'
import * as VueQrcodeReader from "vue-qrcode-reader";

const mycomponents = {
    ...components,
    VTimePicker,
    VNumberInput
}

const vuetify = createVuetify({
    components: mycomponents,
    directives,
    icons: {
        defaultSet: 'mdi',
    },
})

createApp(App)
.use(router)
.use(vuetify)
.use(VueQrcodeReader)
.mount('#app')