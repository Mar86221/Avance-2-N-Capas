import { createWebHistory, createRouter } from "vue-router";

import Home from "../views/Home.vue";
import QrGenerator from "../views/QrGenerator.vue";
import History from "../views/History.vue";
import RequestFamily from "../views/requestFamily.vue";
import FamilyManagement from "../views/family-management.vue";
import ConfirmRequest from "../views/confirm-request.vue";
import ApprovedRequest from "../views/approved-request.vue";
import HouseManagement from "../views/house-management.vue";
import NewHouse from "../views/new-house.vue";
import HistoryEntries from "../views/history-entries.vue";
import Devices from "../views/devices.vue";
import NewDevice from "../views/new-device.vue";
import EditHouse from "../views/edit-house.vue";
import EditDevice from "../views/edit-device.vue";
import GuardManagement from "../views/guard-management.vue";
import StateRequest from "../views/state-request.vue";
import QrError from "../views/qr-error.vue";

const routes = [
    {
        path: '/', component: Home,
    },
    {
        path: '/qr', component: QrGenerator
    },
    {
        path: '/history', component: History
    },
    {
        path: '/family-request', component: RequestFamily
    },
    {
        path: '/family-management', component: FamilyManagement
    },
    {
        path: '/confirm-request', component: ConfirmRequest
    },
    {
        path: '/approved-request', component: ApprovedRequest
    },
    {
        path: '/house-management', component: HouseManagement
    },
    {
        path: '/new-house', component: NewHouse
    },
    {
        path: '/edit-house/:id', component: EditHouse, props: true
    },
    {
        path: '/history-entries', component: HistoryEntries
    },
    {
        path: '/devices', component: Devices
    },
    {
        path: '/new-device', component: NewDevice
    },
    {
        path: '/edit-device/:id', component: EditDevice, props: true
    },
    {
        path: '/guard-management', component: GuardManagement
    },
    {
        path: '/state-request', component: StateRequest
    },
    {
        path: '/qr-error', component: QrError
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router;