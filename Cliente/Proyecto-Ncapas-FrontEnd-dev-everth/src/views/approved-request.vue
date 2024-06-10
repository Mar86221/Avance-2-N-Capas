<template>
<Navbar :residentAdmin="true" />

<div class="d-flex justify-center">
<h3 class="josefin-sans approved-title">Solicitudes de tu familia</h3>
</div>

<div class="card-container">
    <UserCard
      v-for="(user, index) in users"
      :key="index"
      :name="user.name"
      :date="user.date"
      :relatedPerson="user.relatedPerson"
      :showButton="true"
    />
</div>

</template>

<script>
import Navbar from '../components/navbar.vue';
import UserCard from '../components/request-card.vue';
export default {
components: {
  Navbar,
  UserCard
},
data() {
    return {
      users: [
        { name: 'Mirta Ramirez', date: '4/13/2024', relatedPerson: 'Cesar Medina' },
        { name: 'Alicia Alvarez', date: '4/10/2024', relatedPerson: 'Lucía Medina' }
      ]
    };
  },
}
</script>

<style scoped>

.card-container{
    display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
}

.approved-title{
width: 85%;
margin-top: 1em;
color: #000;
text-align: center;
font-feature-settings: 'clig' off, 'liga' off;
font-family: "Josefin Sans";
font-size: 32px;
font-style: normal;
font-weight: 600;
line-height: normal;
}


@media (max-width: 768px ) {
   
}
</style>