<!-- UserCard.vue -->
<template>
    <div @click="handleClick" class="card">
      <span class="span-card">{{ name }}</span>
      <span class="span-card">{{ date }}</span>
      <span class="span-card-person">{{ relatedPerson }}</span>
      <v-btn v-if="showButton" class="btn-revocar">
      <span style="text-transform: none; font-size: 19px; margin-right: 2em; color: #EDF1F4;" >Revocar</span>
      <img src="/src/assets/img/revocar.svg" class="revocar-icon"/>
    </v-btn>
    </div>
  </template>
  
  <script>
  export default {
    name: "UserCard",
    props: {
      name: {
        type: String,
        required: true
      },
      date: {
        type: String,
        required: true
      },
      relatedPerson: {
        type: String,
        required: true
      },
      showButton: {
        type: Boolean,
        default: false
      }
    },
    methods: {
      handleClick(){
        this.$emit('request-click')
      }
    }
  };
  </script>
  
  <style scoped>
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
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  }
  
  .card span {
  color: #171616;
text-align: center;
font-feature-settings: 'clig' off, 'liga' off;
font-family: "Josefin Sans";
font-size: 24px;
font-style: normal;
font-weight: 300;
line-height: normal;
  }

  .btn-revocar {
    color: #EDF1F4;

  height: 62px;
  background: #A1251B;
  border-radius: 20px;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
text-align: center;
font-feature-settings: 'clig' off, 'liga' off;
font-family: "Josefin Sans";
font-size: 20px;
font-style: normal;
font-weight: 400;
}

.btn-revocar span {
  font-family: 'Josefin Sans', sans-serif;
  font-size: 18px;
}

.revocar-icon{
position: absolute;
  right: 15px;
  top: 50%;
  transform: translateY(-50%);
  height: 20px;
}

  @media (max-width: 768px) {
  .card{
    width: auto;
    flex-wrap: wrap;
    display: flex;
    justify-content: center;
    align-items: center;
    height: auto;
    gap: 2px;
  }

  .span-card{
    padding: 0 1em 0 0;
  }

  .span-card-person{
    margin-right: 1em;
    margin-top: 1rem;

  }

  .btn-revocar {
    margin-top: 1rem;
    width: 43%;
    height: 44px;
    justify-content: center;
  }

}
  </style>
  