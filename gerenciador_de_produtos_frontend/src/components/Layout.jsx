import React from 'react';
import { useLocation } from 'react-router-dom';
import Navbar from './Navbar';
import RoutesComponent from './RoutesComponent'; // Este componente contém todas as suas rotas

const Layout = () => {
  const location = useLocation();
  const showNavbar = location.pathname !== "/login";

  return (
    <>
      {showNavbar && <Navbar />}
      <div className="container">
        <RoutesComponent />
      </div>
    </>
  );
};

export default Layout;
