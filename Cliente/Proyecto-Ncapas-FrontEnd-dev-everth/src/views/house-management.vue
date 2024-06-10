<template>
  <Navbar :admin="true" />

  <div class="d-flex justify-center">
    <h3 class="titles-style" style="margin-top: 1em; margin-bottom: 0.5em;">Gestión de hogares </h3>
  </div>

  <div class="container-wrapper">
    <div class="main-container">
      
      <div class="d-flex justify-start search-create-container">
        <div class="search-items">
        <div class="search-div">
          <v-text-field
            v-model="searchQuery"
            placeholder="Buscar casa"
            class="search-field josefin-sans"
            clearable
            hide-details="auto"
            variant="plain"

          >
            <img src="/src/assets/img/search.svg" class="search-icon" />
          </v-text-field>
        </div>
        <v-btn class="josefin-sans btn-create" style="margin-bottom: 1em; margin-left: 0.3em;" @click="RedirectTonewHouse">
          <img src="/src/assets/img/add.svg" class="add-icon" />
          <span style="text-transform: none; font-size: 18px;" class="jostfin-sans">Crear nueva casa</span>
        </v-btn>
      </div>
      </div>

      <div class="card-grid">
        <HouseCardComponent
          v-for="(house, index) in houses"
          :key="index"
          :houseNumber="house.houseNumber"
          :ownerName="house.ownerName"
          :address="house.address"
          :residents="house.residents"
        />
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from '../components/navbar.vue';
import HouseCardComponent from '../components/house-card.vue';
export default {
  components: {
    Navbar,
    HouseCardComponent
  },
  data() {
    return {
      searchQuery: '',
      houses: [
        { houseNumber: '40', ownerName: 'Juan Medina', address: 'Condominio los zorzalitos, Calle El Amate', residents: 4 },
        { houseNumber: '13', ownerName: 'Juan Medina', address: 'Condominio los zorzalitos, Calle El Amate', residents: 4 },
        { houseNumber: '40', ownerName: 'Juan Medina', address: 'Condominio los zorzalitos, Calle El Amate', residents: 4 },
        { houseNumber: '40', ownerName: 'Juan Medina', address: 'Condominio los zorzalitos, Calle El Amate', residents: 4 },
        { houseNumber: '13', ownerName: 'Juan Medina', address: 'Condominio los zorzalitos, Calle El Amate', residents: 4 },
        { houseNumber: '40', ownerName: 'Juan Medina', address: 'Condominio los zorzalitos, Calle El Amate', residents: 4 },
        { houseNumber: '40', ownerName: 'Juan Medina', address: 'Condominio los zorzalitos, Calle El Amate', residents: 4 },
        { houseNumber: '13', ownerName: 'Juan Medina', address: 'Condominio los zorzalitos, Calle El Amate', residents: 4 },
        { houseNumber: '40', ownerName: 'Juan Medina', address: 'Condominio los zorzalitos, Calle El Amate', residents: 4 }
      ]
    }
  },
  methods: {
    RedirectTonewHouse() {
      this.$router.push('/new-house');
  }
  }
}
</script>

<style scoped>
.container-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
}

.main-container {
  width: 75%;
}

.search-create-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
}

.search-field::placeholder {
  color: #979797;
  font-weight: 700;
}

.search-field {
  color: #222;
  background-color: #F3F6F8;
  border-radius: 20px;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
  font-weight: 400;
  font-size: 24px;

}

.search-div {
  width: 528px;
  height: 62px;
}

.btn-create {
  background-color: #12453B;
  color: #EDF1F4;
  font-family: 'Josefin Sans', sans-serif;
  font-size: 16px;
  height: 52px;
  margin-top: 1em;
  width: 244px;
  background-color: #F3F6F8;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
  color: #2B2B2B;
  border-radius: 20px;
  border-radius: var(--Semi-rounded, 12px);
}

.add-icon {
  width: 40px;
  height: 50px;
  margin-right: 25px;
  align-items: flex-start;
}

.search-icon {
  width: 35px;
  background-color: #EDF1F4;
  height: 30px;
  margin-right: 25px;
  margin-left: 1em;
  margin-bottom: 0.5em;
  align-items: center;
  justify-content: center;
}

.search-items{
  display: flex;
  align-items: center;
  width: 100%;
  margin-left: 10rem;
  flex-wrap: wrap;
}

.card-grid {
  display: flex;
  flex-wrap: wrap;
  width: 100%;
  gap: 20px;
  justify-content: center;
}

@media (max-width: 821px) {
  .search-div {
    width: 100%;
    align-self: center;
    align-content: center;
    height: auto;
  }

  .main-container {
  width: 92%;
}
  

  .search-items{

  margin-left: 0;

}

  .search-create-container {
    margin-left: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    flex-wrap: wrap;
    margin: 2em auto 1em auto;
  }
}
</style>