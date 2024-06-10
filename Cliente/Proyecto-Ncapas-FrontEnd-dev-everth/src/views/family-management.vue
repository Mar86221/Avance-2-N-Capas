<template>
<Navbar :residentAdmin="true" />

<div class="d-flex justify-center">
<h3 class="josefin-sans management-title" style="color: #000; font-size: 36px; margin-top: 1em; text-align: center;">Gestión de residentes de tu casa</h3>
</div>

<div class="d-flex justify-center form-container">
    <div v-for="(resident, index) in residents" :key="index" class="resident-form">
      <div class="field-container">
    <h3 class="josefin-sans labels" >Email*</h3>
    <v-text-field placeholder="ejemplo@gmail.com" variant="solo" hide-details="auto" v-model="resident.email" bg-color=#F6F9FB required class="form-label small-input"></v-text-field>
      </div>
      <div class="field-container">
        <h3 class="josefin-sans labels">DUI</h3>
        <v-text-field placeholder="000000-0" variant="solo" hide-details="auto" v-model="resident.dui" bg-color=#F6F9FB required class="form-label small-input"></v-text-field>
      </div>
      <div class="btn-container" style="height: 100%; display: flex; align-self: flex-end; margin-bottom: 0.5rem;">
      <div >
      <v-btn icon @click="addResident" class="add-btn" :disabled="residents.length >= 3">
        <v-icon>mdi-plus</v-icon>
      </v-btn>
      <v-btn icon @click="removeResident(index)" class="remove-btn" :disabled="residents.length <= 1">
        <v-icon>mdi-minus</v-icon>
      </v-btn>
    </div>
    </div>
    </div>
  </div>

  <div class="d-flex justify-center">
  <v-btn class="josefin-sans btn-actualizar" style="margin-top: 4em; margin-bottom: 1em;">
    <span style="text-transform: none; font-size: 18px;" class="jostfin-sans">Actualizar</span>
    </v-btn>
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
      residents: [
        { email: '', dui: '' },
        { email: '', dui: '' }
      ]
    };
  }
,
methods: {
    addResident() {
        if (this.residents.length < 3) {
            this.residents.push({ email: '', dui: '' });
        }    
    },
    removeResident(index) {
        if (this.residents.length > 1) {
            this.residents.splice(index, 1);
        }
    }
  },

}
</script>

<style scoped>

.field-container {
  display: flex;
  flex-direction: column;
}

.form-container{
    flex-direction: column;
    margin-top: 3em;
}

.labels {
    width: 223px;
    color: #000;
    font-feature-settings: 'clig' off, 'liga' off;
    font-family: "Josefin Sans";
    font-size: 24px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
    margin-bottom: 0.3rem;
    margin-top: 1rem;
  }

  .form-label {
    border-radius: 4px;
    border: 1px solid #12453B;
    color: #12453B;
    width: 100%;
  }

.resident-form {
  justify-content: center;
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 10px;
  padding: 1em;
}

.management-title{
width: 93%;
color: #000;
text-align: center;
font-feature-settings: 'clig' off, 'liga' off;
font-family: "Josefin Sans";
font-size: 32px;
font-style: normal;
font-weight: 600;
line-height: normal;
}

.email-field{
   width: 300px;
   border-radius: 8px;
   background-color: white;
   border: 1px solid #12453B;
}

.dui-field{
    width: 209px;
    border-radius: 8px;
    background-color: white;
    border: 1px solid #12453B;
}

.add-btn,
.remove-btn {
  min-width: 36px;
  min-height: 36px;
  background-color: #12453B;
  color: #EDF1F4;
  margin-top: 1.5em;
}

.update-btn {
  width: 150px;
  height: 45px;
  margin-top: 1em;
  background-color: #12453B;
  color: #EDF1F4;
  border-radius: 10px;
}

.btn-actualizar{
  color: #FFF;
  width: 169px;
  height: 48px;
  background: #12453B;
  border-radius: 20px;
}

.remove-btn {
    margin-left: 0.5em;
  }

@media (max-width: 605px ) {
  .resident-form {
    justify-content: start;
}

  
  
}
</style>