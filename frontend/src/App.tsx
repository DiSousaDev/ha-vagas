import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from 'components/Navbar';
import Listing from 'pages/Listing';
import Admin from 'pages/Admin';
import Footer from 'components/Footer';

function App() {
  return (
      <Router>
        <Navbar />
        <Routes>
            <Route path="/" caseSensitive={false} element={<Listing />} />
            <Route path="/admin" caseSensitive={false} element={<Admin />} />
        </Routes>
        <Footer />
      </Router>
  );
}

export default App;
