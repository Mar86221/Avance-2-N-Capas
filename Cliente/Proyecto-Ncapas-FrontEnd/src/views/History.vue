<template>
<Navbar v-if="storedRole === 'resident-admin'" :residentAdmin="true" />
<Navbar v-if="storedRole === 'resident'" :resident="true" />
<Navbar v-if="storedRole === 'visitor'" :visitor="true" />

<div class="d-flex justify-center">
<h3 class="josefin-sans history-title" style="" v-if="storedRole === 'resident-admin'">Historial de entradas a tu casa </h3>
<h3 class="josefin-sans history-title" style="" v-if="storedRole === 'resident'">Historial de tus entradas </h3>
<h3 class="josefin-sans history-title" style="" v-if="storedRole === 'visitor'">Historial de tus entradas </h3>

</div>

<HistoryTable v-if="storedRole === 'resident-admin'" :entries="entries"  />
<HistoryTable v-if="storedRole === 'resident'" :entries="entries_resident"  />
<HistoryTable v-if="storedRole === 'visitor'" :entries="entries_visitor"  />

</template>

<script>
import Navbar from '../components/navbar.vue';
import HistoryTable from '../components/historytable.vue';
export default {
components: {
  Navbar,
  HistoryTable
},
data() {
    return {
      entries: [
        { id: 1, nombre: 'Juan Medina', tipo: 'Residente', fecha: '12/4/2024', acceso: 'Peatonal', hora: '9:00 AM' },
        { id: 2, nombre: 'Leo Perez', tipo: 'Visitante', fecha: '12/4/2024', acceso: 'Vehicular', hora: '8:00 AM' },
        { id: 3, nombre: 'Leo Perez', tipo: 'Visitante', fecha: '12/4/2024', acceso: 'Vehicular', hora: '7:00 PM' },
        { id: 4, nombre: 'Juan Medina', tipo: 'Residente', fecha: '12/4/2024', acceso: 'Peatonal', hora: '9:00 AM' },
        { id: 5, nombre: 'Leo Perez', tipo: 'Visitante', fecha: '12/4/2024', acceso: 'Vehicular', hora: '8:00 AM' },
        { id: 6, nombre: 'Leo Perez', tipo: 'Visitante', fecha: '12/4/2024', acceso: 'Vehicular', hora: '7:00 PM' },
      ],
      entries_resident: [
        { id: 1, nombre: 'Duglas Pineda', fecha: '12/4/2024', acceso: 'Peatonal', hora: '9:00 AM' },
        { id: 2, nombre: 'Duglas Pineda', fecha: '12/4/2024', acceso: 'Vehicular', hora: '8:00 AM' },
        { id: 3, nombre: 'Duglas Pineda',fecha: '12/4/2024', acceso: 'Vehicular', hora: '7:00 PM' },
        { id: 4, nombre: 'Duglas Pineda',fecha: '12/4/2024', acceso: 'Peatonal', hora: '9:00 AM' },
        { id: 5, nombre: 'Duglas Pineda', fecha: '12/4/2024', acceso: 'Vehicular', hora: '8:00 AM' },
        { id: 6, nombre: 'Duglas Pineda', fecha: '12/4/2024', acceso: 'Vehicular', hora: '7:00 PM' },
      ],
      entries_visitor: [
        { id: 1, nombre: 'Daniel Pérez', fecha: '12/4/2024', acceso: 'Peatonal', hora: '9:00 AM' },
        { id: 2, nombre: 'Daniel Pérez', fecha: '12/4/2024', acceso: 'Vehicular', hora: '8:00 AM' },
        { id: 3, nombre: 'Daniel Pérez',fecha: '12/4/2024', acceso: 'Vehicular', hora: '7:00 PM' },
        { id: 4, nombre: 'Daniel Pérez',fecha: '12/4/2024', acceso: 'Peatonal', hora: '9:00 AM' },
        { id: 5, nombre: 'Daniel Pérez', fecha: '12/4/2024', acceso: 'Vehicular', hora: '8:00 AM' },
        { id: 6, nombre: 'Daniel Pérez', fecha: '12/4/2024', acceso: 'Vehicular', hora: '7:00 PM' },
      ],
      storedRole: '',
    }
  },
  mounted(){
     const storedRole = localStorage.getItem('userRole');
     this.storedRole = storedRole;
  }
}
</script>

<style scoped>

.history-title{
margin-top: 2rem;
margin-bottom: 2rem;
 width: 85%; 
color: #000;
text-align: center;
font-feature-settings: 'clig' off, 'liga' off;
font-family: "Josefin Sans";
font-size: 32px;
font-style: normal;
font-weight: 600;
line-height: normal;
}

@media (max-width: 768px ) {
  h3{
    text-align: center;
  }
}
</style>