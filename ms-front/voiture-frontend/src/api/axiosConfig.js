import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8888/voitures", // Full backend URL
  headers: {
    "Content-Type": "application/json",
  },
});

export const getVoitures = async () => {
  try {
    const response = await axiosInstance.get("/");
    return response.data;
  } catch (error) {
    console.error("Error fetching voitures:", error);
    throw error;
  }
};

export const getClients = async () => {
  try {
    const response = await axios.get("http://localhost:8888/clients"); // Adjust endpoint as necessary
    return response.data;
  } catch (error) {
    console.error("Error fetching clients:", error);
    throw error;
  }
};

export const postVoiture = async (clientId, voiture) => {
  try {
    const response = await axiosInstance.post(`/${clientId}`, voiture);
    return response.data;
  } catch (error) {
    console.error("Error adding voiture:", error);
    throw error;
  }3
};

export default axiosInstance;
