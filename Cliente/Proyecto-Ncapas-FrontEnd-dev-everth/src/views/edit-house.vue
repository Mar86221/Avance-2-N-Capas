<template>
    <Navbar :admin="true" />
    
    <div class="d-flex justify-center">
      <h3 class="josefin-sans titles-style" style="color: #000; font-size: 36px; margin-top: 1em; text-align: center;">Modificar una casa</h3>
    </div>
    
    <div class="d-flex justify-center mt-5 main-div">
      <form class="house-form">
        <div class="form-label">
          <div class="form-row">
            <div class="form-group">
              <h3 class="josefin-sans labels" style="color: #000;">Email encargado</h3>
              <v-text-field placeholder="ejemplo@gmail.com" variant="solo" hide-details="auto" v-model="formData.emailEncargado" bg-color="#F6F9FB" required class="form-input small-input"></v-text-field>
            </div>
            <div class="form-group number-label">
              <h3 class="josefin-sans labels" style="color: #000;">Número de casa</h3>
              <v-number-input hide-details="auto" class="number-input" variant="solo" control-variant="default" v-model="formData.numeroCasa" :max="10" :min="0"></v-number-input>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group">
              <h3 class="josefin-sans labels" style="color: #000;">Dirección</h3>
              <v-text-field variant="solo" hide-details="auto" v-model="formData.direccion" bg-color="#F6F9FB" required class="form-input small-input"></v-text-field>
            </div>
            <div class="form-group number-label">
              <h3 class="josefin-sans labels" style="color: #000; width: 251px;">Cantidad de residentes</h3>
              <v-number-input hide-details="auto" class="number-input" variant="solo" control-variant="default" v-model="formData.cantidadResidentes" :max="10" :min="0"></v-number-input>
            </div>
          </div>
        </div>
    
        <div class="form-section">
          <h3 class="d-flex justify-center josefin-sans labels" style="color: #000;">Residentes</h3>
          <div v-for="(residente, index) in formData.residentes" :key="index" class="resident-row">
            <div class="column-group">
              <div class="resident-group">
                <h3 class="josefin-sans labels">Email</h3>
                <v-text-field placeholder="ejemplo@gmail.com" variant="solo" hide-details="auto" v-model="residente.email" bg-color="#F6F9FB" required class="form-input small-input"></v-text-field>
              </div>
              <div class="resident-group">
                <h3 class="josefin-sans labels">DUI</h3>
                <v-text-field placeholder="000000-0" variant="solo" hide-details="auto" v-model="residente.dui" bg-color="#F6F9FB" required class="form-input small-input"></v-text-field>
              </div>
            </div>
            <div class="btn-container">
              <v-btn icon @click="addResidente" class="buttons" :disabled="formData.residentes.length >= 3" style="margin-right: 1em;">
                <v-icon>mdi-plus</v-icon>
              </v-btn>
              <v-btn icon @click="removeResidente(index)" :disabled="formData.residentes.length === 1" class="buttons">
                <v-icon>mdi-minus</v-icon>
              </v-btn>
            </div>
          </div>
        </div>
        <div class="d-flex justify-center">
          <v-btn class="josefin-sans btn-actualizar" style="margin-top: 1.5em; margin-bottom: 4em;">
            <span style="text-transform: none; font-size: 18px;" class="jostfin-sans">Modificar</span>
          </v-btn>
        </div>
      </form>
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
          formData: {
            emailEncargado: 'encargado@example.com',
            numeroCasa: 5,
            direccion: '1234 Main St',
            cantidadResidentes: 2,
            residentes: [
              { email: 'residente1@example.com', dui: '123456-7' },
              { email: 'residente2@example.com', dui: '765432-1' }
            ],
          },
        };
      },
      methods: {
        addResidente() {
          if (this.formData.residentes.length < 3) {
            this.formData.residentes.push({ email: '', dui: '' });
          }
        },
        removeResidente(index) {
          if (this.formData.residentes.length > 1) {
            this.formData.residentes.splice(index, 1);
          }
        },
      },
    }
    </script>
    
    <style scoped>
    .house-form {
      width: 900px;
      background-color: #edf1f4;
      border-radius: 15px;
    }
    
    .btn-actualizar {
      color: #FFF;
      width: 169px;
      height: 48px;
      background: #12453B;
      border-radius: 20px;
    }
    
    .form-row {
      display: flex;
      justify-content: space-between;
      margin-bottom: 1.5em;
    }
    
    .form-input {
      border-radius: 4px;
      border: 1px solid #12453B;
      color: #12453B;
      width: auto;
    }
    
    .form-group {
      flex: 1;
      margin-right: 1em;
    }
    
    .resident-group {
      flex: 1;
      margin-right: 1em;
    }
    
    .form-group:last-child {
      margin-right: 0;
    }
    
    .form-section {
      margin-top: 2em;
    }
    
    .labels {
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
    
    .resident-row {
      display: flex;
      margin-bottom: 1em;
    }
    
    .column-group {
      display: flex;
      width: 80%;
      flex-wrap: wrap;
    }
    
    .resident-row v-text-field {
      flex: 1;
      margin-right: 1em;
    }
    
    .resident-row v-btn {
      margin-left: 0.5em;
    }
    
    .buttons {
      min-width: 36px;
      min-height: 36px;
      background-color: #12453B;
      color: #EDF1F4;
      margin-top: 1.5em;
    }
    
    .number-input {
      width: 182px;
      border-radius: 4px;
      border: 1px solid #12453B;
      color: #12453B
    }
    
    .number-label {
      margin-left: 13em;
    }
    
    .text-field {
      width: 345px;
      background: #F6F9FB;
      border-radius: 8px;
      border: 1.5px solid #12453B;
    }
    
    .btn-container {
      display: flex;
      margin-top: 1.5rem;
    }
    
    @media (max-width: 1024px) {
      .titles-style {
        width: 85%;
      }
    
      .house-form {
        width: 85%;
      }
    
      .number-input {
        width: auto;
        margin-left: 0;
      }
    
      .text-field {
        width: auto;
      }
    
      .form-row {
        margin-bottom: 1.5em;
        display: block;
      }
    
      .main-div {
        display: block;
      }
    
      .resident-group {
        flex: none;
        width: 95%;
      }
    
      .number-label {
        margin-left: 0;
        width: 182px;
      }
    }
    </style>
    