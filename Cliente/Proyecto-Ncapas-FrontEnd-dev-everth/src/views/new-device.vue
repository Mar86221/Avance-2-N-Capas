<template>
<Navbar :admin="true" />

<div class="d-flex justify-center">
        <h3 class="josefin-sans titles-style" style="text-align: center; margin-top: 1em; " >Crear un nuevo dispositivo</h3>
</div>

<div class="form-container">
    <div class="form-row">
      <div class="form-field">
        <h3 class="josefin-sans field-title">Número serial</h3>
        <v-text-field 
        bg-color=#F6F9FB
          v-model="serialNumber" 
          class="input-field"
          variant="solo"
          hide-details
        ></v-text-field>
      </div>
      <div class="form-field-left">
        <h3 class="josefin-sans field-title">Email encargado</h3>
        <v-text-field 
        bg-color=#F6F9FB
          v-model="email" 
          class="input-field"
          variant="solo"
          hide-details
          placeholder="ejemplo@gmail.com"
        ></v-text-field>
      </div>
    </div>
    <div class="form-row">
      <div class="form-field">
        <h3 class="josefin-sans field-title">Punto de acceso</h3>
        <v-select 
        bg-color=#F6F9FB
          v-model="accessPoint" 
          :items="accessPoints" 
          class="input-field"
          variant="solo"
          hide-details
        ></v-select>
      </div>
    </div>
    <div class="form-row d-flex justify-center" style="align-items: center;">
      <v-btn class="create-btn">Crear</v-btn>
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
      serialNumber: '',
      email: '',
      accessPoint: null,
      accessPoints: ['Pluma', 'Caseta', 'Peatonal'],
    };
  },
}
</script>

<style scoped>
.title {
  color: #000;
  font-size: 36px;
  text-align: center;
  margin-top: 1em;
}

.form-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 2em;
}

.form-row {
  display: flex;
  justify-content: left;
  margin-bottom: 1.5em;
  width: 50%;
}

.form-field {
  width: 50%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;

}

.form-field-left {
  width: 50%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;

}

.field-title {
    color: #000;
    font-feature-settings: 'clig' off, 'liga' off;
    font-family: "Josefin Sans";
    font-size: 24px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
    margin-bottom: 0.3rem;
    margin-top: 2rem;
}

.input-field {
  width: 70%;
  border-radius: 4px;
    border: 1px solid #12453B;
    color: #12453B;
}

.create-btn {
  background-color: #12453B;
  color: white;
  font-size: 16px;
  font-weight: bold;
  text-transform: none;
  padding: 0.5em 2em;
  margin-top: 3em;
  height: 45px;
  width: 159px;
  border-radius: 20px;
}

@media (max-width: 1024px ) {


    .form-row{
      flex-direction: column;
      width: 85%;
    }

    .form-field-left{
        margin-bottom: 1em;
        width: 100%;
    }

    .form-field{
        margin-bottom: 1em;
        width: 100%;
    }

    .input-field{
      width: 95%;
    }

    
    
}
</style>
