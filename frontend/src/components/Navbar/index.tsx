import { ReactComponent as GithubIcon } from 'assets/img/github.svg';
import { Link } from 'react-router-dom';
import "./styles.css";

function Navbar() {
    return (
      <header>
        <nav className="container">
          <div className="havagas-nav-content">
            <Link to='/'>
            <h1>Há Vagas!</h1>
            </Link>
            <a href="https://github.com/DiSousaDev">
              <div className="havagas-contact-container">
                <GithubIcon />
                <p className="havagas-contact-link">/DiSousaDev</p>
              </div>
            </a>
          </div>
        </nav>
      </header>
    );
  }
  
  export default Navbar;