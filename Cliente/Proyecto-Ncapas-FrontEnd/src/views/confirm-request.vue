<template>
<Navbar :residentAdmin="true" />

<div class="d-flex justify-center">
<h3 class="josefin-sans confirm-title" >Solicitud hecha por Lúcia</h3>
</div>

<div class="d-flex justify-center request mt-5">
<div class="info-grid">
    <div class="info-item">
        <label class="info-label">Email</label>
        <h3 class="info-value josefin-sans-light">alia@gmail.com</h3>
    </div>
    <div class="info-item">
        <label class="info-label">Nombre</label>
        <h3 class="info-value josefin-sans-light">Alicia Álvarez</h3>
    </div>
    <div class="info-item">
        <label class="info-label">DUI</label>
        <h3 class="info-value josefin-sans-light">02438326-9</h3>
    </div>
    <div class="info-item">
        <label class="info-label">Hora de entrada</label>
        <h3 class="info-value josefin-sans-light">10:00 AM</h3>
      </div>
      <div class="info-item">
        <label class="info-label">Fecha de entrada</label>
        <h3 class="info-value josefin-sans-light">4/20/2024</h3>
      </div>
      <div class="info-item">
        <label class="info-label">Días de entrada</label>
        <h3 class="info-value josefin-sans-light">Lunes, Martes, Domingo</h3>
      </div>
</div>
</div>

<div class="d-flex justify-center">
  <v-btn class="josefin-sans btn-aceptar" style="margin-top: 4em; margin-bottom: 1em;">
    <span style="text-transform: none; font-size: 18px;" class="jostfin-sans">Aceptar</span>
    </v-btn>
    <v-btn class="josefin-sans btn-rechazar" style="margin-top: 4em; margin-bottom: 1em;">
    <span style="text-transform: none; font-size: 18px;" class="jostfin-sans">Rechazar</span>
    </v-btn>
</div> 


</template>

<script>
import Navbar from '../components/navbar.vue';
export default {
components: {
  Navbar,
},
}
</script>

<style scoped>
.request {
    width: 85%;
    height: 341px;
    background-color: #F3F6F8;
    margin: auto;
    border-radius: 30px;
    box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
}

.info-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 1.5em;
  padding: 2em;
  width: 100%;
}

.info-item {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
}

.confirm-title{
  width: 85%;
  color: #000;
text-align: center;
font-feature-settings: 'clig' off, 'liga' off;
font-family: "Josefin Sans";
font-size: 32px;
font-style: normal;
font-weight: 600;
line-height: normal;
margin-top: 1em;
}

.info-label {
  font-family: 'Josefin Sans', sans-serif;
  color: #000;
  margin-bottom: 0.5em;
}

.info-value {
  font-family: 'Josefin Sans', sans-serif;
  color: #000;
}

.btn-aceptar{
  color: #FFF;
  width: 169px;
  height: 58px;
  background: #12453B;
  border-radius: 20px;
}

.btn-rechazar{
  color: #12453B;
  width: 169px;
  height: 58px;
  background: #EDF1F4;
  border-radius: 20px;
  border: 1.5px solid #12453B;
  margin-left: 2em;
}

@media (max-width: 768px ) {
    .request {
    padding: 1em;
    height: auto;
  }

  .btn-rechazar {
    margin-left: 0.5em;
    margin-top: 1em;
  }

  .info-grid {
    padding: 1em;
    display: flex;
    flex-direction: column;
  }

  .info-item {
    margin-bottom: 1em;
  }

  .info-value {
    margin-bottom: 0;
  }
}
</style>