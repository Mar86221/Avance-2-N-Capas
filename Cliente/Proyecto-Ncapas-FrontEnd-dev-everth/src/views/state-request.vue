<template>
    <Navbar :resident="true" />
    
    <div class="d-flex justify-center">
      <h3 class="josefin-sans state-title">Estado de solicitudes de acceso</h3>
    </div>
    
    <div class="d-flex justify-center flex-column" style="margin-bottom: 1.5em;">
      <div
        v-for="solicitud in solicitudes"
        :key="solicitud.nombre"
        :class="['card', getStatusClass(solicitud.estado)]"
      >
        <span class="nombre">{{ solicitud.nombre }}</span>
        <span class="fecha">{{ solicitud.fecha }}</span>
        <span class="estado">{{ solicitud.estado }}</span>
      </div>
    </div>
  </template>
  
  <script>
  import Navbar from '../components/navbar.vue';
  
  export default {
    components: {
      Navbar,
    },
    data() {
      return {
        solicitudes: [
          { nombre: 'Juan Torres', fecha: '4/20/2024', estado: 'Pendiente' },
          { nombre: 'Mirta Ramirez', fecha: '4/13/2024', estado: 'Aprobada' },
          { nombre: 'Alicia Alvarez', fecha: '4/10/2024', estado: 'Rechazada' },
        ],
      };
    },
    methods: {
      getStatusClass(estado) {
        switch (estado) {
          case 'Aprobada':
            return 'aprobada';
          case 'Rechazada':
            return 'rechazada';
          case 'Pendiente':
            return 'pendiente';
          default:
            return '';
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .state-title {
    margin-top: 2rem;
    margin-bottom: 2rem;
    width: 85%;
    color: #000;
    text-align: center;
    font-feature-settings: 'clig' off, 'liga' off;
    font-family: 'Josefin Sans';
    font-size: 32px;
    font-style: normal;
    font-weight: 600;
    line-height: normal;
  }
  
  .d-flex {
    display: flex;
    gap: 10px;
    flex-grow: 1;
    justify-content: center;
  }
  
  .flex-column {
    flex-direction: column;
    align-items: center;
  }
  
  .card {
    width: auto;
    height: auto;
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
    align-items: center;
    background-color: #f6f9fb;
    cursor: pointer;
    border-radius: 20px;
    padding: 25px;
    width: 45%;
    height: 166px;
    margin: 10px 0;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); }
  
  .nombre, .fecha, .estado {
    color: #171616;
text-align: center;
font-feature-settings: 'clig' off, 'liga' off;
font-family: "Josefin Sans";
font-size: 24px;
font-style: normal;
font-weight: 300;
line-height: normal;
  }
  
  .aprobada {
    background-color: #d4edda;
  }
  
  .rechazada {
    background-color: #f8d7da;
  }
  
  .pendiente {
    background-color: #fefefe;
  }

  @media (max-width: 1024px) {
    .card{
        width: 350px;
        height:  139px;
    }
  }

  </style>
  