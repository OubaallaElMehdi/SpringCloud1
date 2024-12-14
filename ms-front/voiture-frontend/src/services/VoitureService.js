import axios from "axios";

const API_URL = "http://localhost:8888/ms-voiture";

export const getAllVoitures = () => {
  return axios.get(`${API_URL}/voitures/all`);
};

export const getVoituresByClient = (clientId) => {
  return axios.get(`${API_URL}/voitures/client/${clientId}`);
};

export const addVoiture = (clientId, voiture) => {
  return axios.post(`http://localhost:8089/voitures/${clientId}`, voiture);
};
