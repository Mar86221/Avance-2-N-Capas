<template>
<Navbar :visitor="true" />
<div class="error-container">
    <div class="error-image">
      <img src="/src/assets/img/qr-error.svg" alt="QR Code Error" class="qr-error" />
      <img src="/src/assets/img/error.svg" alt="Error Icon" class="error-icon" />
    </div>
    <p class="error-message"> Aún no tienes solicitud de acceso válida.    </p>
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
.error-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
  color: #2E2E2E;
  margin-top: 8em;
}

.error-image {
  position: relative;
}

.qr-error {
  width: 185px;
  height: 185px;
}

.error-icon {
  position: absolute;
  top: 45%;
  left: 75%;
  width: 91px;
  height: 91px;
}

.error-message {
  margin-top: 2em;

  width: 30%;
  color: #000;
text-align: center;
font-feature-settings: 'clig' off, 'liga' off;
font-family: "Josefin Sans";
font-size: 24px;
font-style: normal;
font-weight: 300;
line-height: normal;
}

@media (max-width: 1024px ) {
    .error-container{
        margin-top: 5em;
    }

    .error-message{
      width: 85%;
    }
}
</style>
