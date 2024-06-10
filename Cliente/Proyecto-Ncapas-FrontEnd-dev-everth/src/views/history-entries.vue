<template>
    <div>
      <Navbar :admin="true" />
      <div class="d-flex justify-center">
        <h3 class="titles-style" style="text-align: center; margin-top: 2em;" >Historial de entradas</h3>
        </div>
      
 
        <div class="content-container">
      <h3 class="josefin-sans title" style="margin-bottom: 0.5em;">Gráficos</h3>
      <div class="charts-container">
        <div class="chart-item-bar">
          <h3 class="chart-title josefin-sans-light">Cantidad de entradas por día</h3>
          <Bar class="chart" :data="chartData" :options="chartOptions" />
        </div>
        <div class="chart-item">
          <h3 class="chart-title josefin-sans-light">Entradas por punto de acceso</h3>
          <Pie class="chart" style="height: 248px;" :data="pieDataAccess" :options="pieOptions" />
        </div>
        <div class="chart-item">
          <h3 class="chart-title josefin-sans-light">Entradas de visitas por tipo</h3>
          <Pie class="chart" style="height: 248px;" :data="pieDataVisit" :options="pieOptions" />
        </div>
      </div>
  
        <h3 class="josefin-sans title" style="margin-bottom: 1em;">Todas las entradas</h3>
        
      </div>
      <v-data-table :headers="headers"  :items="entries" class="entries-table">
      </v-data-table>
    </div>
  </template>
  
  <script>
  import Navbar from '../components/navbar.vue';
  import { Bar, Pie } from 'vue-chartjs';
  import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale, ArcElement } from 'chart.js'
  
  ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale, ArcElement)
  
  export default {
    components: {
      Navbar,
      Bar,
      Pie
    },
    data() {
      return {
        headers: [
          { title: 'Nombre', value: 'name' },
          { title: 'DUI', value: 'id' },
          { title: 'Casa', value: 'house' },
          { title: 'Fecha', value: 'date' },
          { title: 'Hora', value: 'time' },
        ],
        entries: [
          { name: 'Juan Medina', id: '3234567-8', house: 'Casa # 25', date: '12/4/2024', time: '9:00 AM' },
          { name: 'Leo Perez', id: '3234567-8', house: 'Casa # 45', date: '12/4/2024', time: '8:00 AM' },
          { name: 'Leo Perez', id: '3234567-8', house: 'Casa # 45', date: '12/4/2024', time: '7:00 PM' },
        ],
        chartData: {
          labels: ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo'],
          datasets: [
            {
              label: 'Cantidad de entradas por día',
              backgroundColor: '#12453B',
              data: [5, 10, 8, 6, 9, 12, 11],
            },
          ],
        },
        pieDataAccess: {
          labels: ['Principal', 'Secundario'],
          datasets: [
            {
              label: 'Entradas por punto de acceso',
              backgroundColor: ['#FEAEAE', '#D0E8FF'],
              data: [60, 40],
            },
          ],
        },
        pieDataVisit: {
          labels: ['Residente', 'Visita', 'Anonima'],
          datasets: [
            {
              label: 'Entradas de visitas por tipo',
              backgroundColor: ['#FEAEAE', '#D0E8FF', '#A9F4D0'],
              data: [50, 30, 10],
            },
          ],
        },
        chartOptions: {
          responsive: true,
          maintainAspectRatio: false,
        },
        pieOptions: {
          responsive: true,
          maintainAspectRatio: false,
        },
      };
    },
  };
  </script>
  
  <style scoped>
  .content-container {
    padding: 1em;
    margin-left: 3em;
  }
  
  .title {
    color: #171616;
text-align: center;
font-feature-settings: 'clig' off, 'liga' off;
font-family: "Josefin Sans";
font-size: 24px;
font-style: normal;
font-weight: 400;
line-height: normal;
    text-align: left;
  }
  
  .charts-container {
    display: flex;
    flex-direction: row;
    margin-bottom: 3em;
    flex-wrap: wrap;
    gap: 2em;

  }
  
  .entries-table {
    background-color: #EDF1F4;
  }


.chart-item {
  min-width: 500px;
  max-width: 343px;
  flex-shrink: 0;
  height: 330px;
  background-color: #F6F9FB;
  border-radius: 30px;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1em;
}

.chart-item-bar{
  width: 40%;
  min-width: 343px;
  flex-shrink: 0;
  height: 330px;
  background-color: #F6F9FB;
  border-radius: 30px;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1em;
}

.chart {
    height: 258px !important;
}

.chart-title {
  color: #000;

text-align: center;
font-feature-settings: 'clig' off, 'liga' off;
font-family: "Josefin Sans";
font-size: 20px;
font-style: normal;
font-weight: 300;
line-height: normal;
}
  
  .v-data-table {
    width: 100%;
  }
  
  .josefin-sans {
    font-family: 'Josefin Sans', sans-serif;
  }

  @media (max-width: 1024px ) {
    .chart-item {
      min-width: 90%;
      height: 330px;
    }

    .chart-item-bar{
      min-width: 92%;
      height: 340px;
    }

    .chart{
      width: 100%;
      height: 100%;
    
    }
    .content-container {
    padding: 1em;
    margin-left: 1em;
  }
}
  </style>
  