<template>
    <div class="card">
      <div class="card-header">
        <h4 class="card-title">Casa # {{ houseNumber }}</h4>
        <h4 class="card-title" style="font-weight: 300;">{{ ownerName }}</h4>
      </div>
      <div class="card-body" style="font-weight: 300; font-size: 20px;">
        <p>{{ address }}</p>
      </div>
      <div class="card-footer">
        <p>Residentes: {{ residents }}</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      houseNumber: {
        type: String,
        required: true
      },
      ownerName: {
        type: String,
        required: true
      },
      address: {
        type: String,
        required: true
      },
      residents: {
        type: Number,
        required: true
      }
    }
  }
  </script>
  
  <style scoped>
  .card {
    background-color: #F6F9FB;
    border-radius: 30px;
    padding: 20px;
    margin: 10px;
    width: 338px;
    height: 163px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }
  
  .card-header {
    display: flex;
    justify-content: space-between;
  }
  
  .card-title {
    font-family: 'Josefin Sans', sans-serif;
    font-size: 20px;
    color: #000;
    font-size: 18px;
    margin: 0;
  }
  
  .card-body {
    margin: 10px 0;
    font-family: 'Josefin Sans', sans-serif;
    text-align: center;
  }
  
  .card-footer {
    font-family: 'Josefin Sans', sans-serif;
    color: #000;
    font-size: 20px;
    font-weight: 350;
    margin-top: 10px;
    text-align: center;
  }
  </style>
  