import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Sidebar from './components/Sidebar';
import HomePage from './pages/HomePage'; // Import HomePage once
import VoituresPage from './pages/VoituresPage'; // Ensure correct file name and location
import ClientsPage from './pages/ClientsPage';

const App = () => {
  return (
    <Router>
      <div className="flex">
        {/* Sidebar */}
        <Sidebar />

        {/* Main Content */}
        <div className="ml-64 p-6 w-full">
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/voitures" element={<VoituresPage />} />
            <Route path="/clients" element={<ClientsPage />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
};

export default App;
