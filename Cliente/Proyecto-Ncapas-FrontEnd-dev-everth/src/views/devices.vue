<template>
    <Navbar :admin="true" />
  
    <div class="d-flex justify-center devices-card">
      <div class="d-flex title-div">
        <h3 class="josefin-sans devices-title">Dispositivos</h3>
        <div class="d-flex justify-center mt-5">
          <v-btn class="josefin-sans btn-add"  @click="redirecToNewDevice">
            <img src="/src/assets/img/plus.svg" class="plus-icon"/>
            <span style="text-transform: none; font-size: 18px;" class="jostfin-sans">Agregar dispositivo</span>
          </v-btn>
        </div>
      </div>
    </div>
  
    <div class="d-flex justify-center card-container">
    <div v-for="device in devices" :key="device.id" class="device-card">
      <div class="device-header">
        <img src="/src/assets/img/device.svg" class="device-icon"/>
      </div>
      <div class="device-content">
        <span class="device-name josefin-sans">{{ device.name }}</span>
        <div class="device-owner josefin-sans">{{ device.owner }}</div>
      </div>
    </div>
  </div>
  
    <div class="d-flex justify-center duration-container">
      <h3 class="josefin-sans devices-title-number">Duración del código QR (minutos)</h3>
    </div>
    <div class="d-flex  devices-number">
      <div class="number-div" style="width: 182px;">
        <v-number-input hide-details="auto" class="number-input" placeholder="56" variant="solo" control-variant="default" :max="60" :min="0"></v-number-input>
  
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
        devices: [
          { id: 1, name: 'Pluma', owner: 'Ricardo Pérez' },
          { id: 2, name: 'Caseta', owner: 'Jorge López' },
          { id: 3, name: 'Peatonal', owner: 'Jose Guevara' },
        ],
      };
    },
    methods: {
      redirecToNewDevice(){
        this.$router.push('/new-device');
      }
    }
  };
  </script>
  

  <style scoped>
  .devices-card {
    margin-top: 1.5em;
    margin-bottom: 2em;
  }
  
  .devices-title {
    width: 100%;
    color: #000;
    text-align: start;
    font-feature-settings: 'clig' off, 'liga' off;
    font-family: "Josefin Sans";
    font-size: 32px;
    font-style: normal;
    font-weight: 600;
    line-height: normal;
    margin-right: 18em;
    margin-top: 1em;
  }

  .devices-title-number {
    width: 100%;
    color: #000;
    text-align: center;
    font-feature-settings: 'clig' off, 'liga' off;
    font-family: "Josefin Sans";
    font-size: 32px;
    font-style: normal;
    font-weight: 600;
    line-height: normal;
    margin-top: 4em;
  }
  
  .plus-icon {
    color: #12453B;
    margin-right: 0.4em;
  }
  

  
  .btn-add {
    width: 245px;
   height: 41px;
    border-radius: 15px;
    background-color: #F6F9FB;
    box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);

font-family: "Josefin Sans";
font-size: 20px;
font-style: normal;
font-weight: 400;
line-height: normal;
    
  }
  
  .number-input {
    width: 182px;
    margin-top: 2em;
    background: #F6F9FB;
    margin-bottom: 3em;
    border-radius: 4px;
    border: 1px solid #12453B;
  }
  
  .card-container {
    display: flex;
    justify-content: center;
    gap: 2em;
    flex-wrap: wrap;
    flex-direction: row;
  }

  .devices-number{
    display: flex;
    justify-content: center !important;
  }
  
  .device-card {
    background-color: #F6F9FB;
    box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
    width: 324px;
    height: 163px;
    padding: 1em;
    border-radius: 30px;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    text-align: left;
  }
  
  .device-header {
    margin-bottom: 0.5em;
  }

  .device-icon {
  width: 24px;
  height: 24px;
}

  .device-name {
   color: #171616;

font-feature-settings: 'clig' off, 'liga' off;
font-family: "Josefin Sans";
font-size: 24px;
font-style: normal;
font-weight: 700;
line-height: normal;
  }

  .device-content {
  display: flex;
  flex-direction: column;
}



  
  .device-owner {
    margin-top: 1em;
    font-weight: 300;
    color: #6B6B6B;
    font-size: 20px;
  }



  @media (max-width: 1024px ) {

    .devices-title{
      margin-right: 0;
      text-align: center;

    }

    .title-div{
        flex-direction: column;
        text-align: start;
        width: 60%;
    }

    .btn-add{
        margin-top: 2em;

    }

    .devices-title-number {
    width: 85%;
    color: #000;
    text-align: center;
    font-feature-settings: 'clig' off, 'liga' off;
    font-family: "Josefin Sans";
    font-size: 32px;
    font-style: normal;
    font-weight: 600;
    line-height: normal;
    margin-right: 0;
    margin-top: 1em;
  }

  .number-input{
    margin-left: 0em;
    margin-top: 2em;
  }

  .number-div{
    display: flex;
    justify-content: center;
    margin-bottom: 1.5em;
  }



}
  </style>
  