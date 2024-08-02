import React from 'react'
import hummel from '../assets/hummel.png'
import { Link, NavLink } from 'react-router-dom'


export default function NavBar() {
    
    return (<>
        <nav className='nav'>
            <img src={hummel} alt='Hummel' width={'150'}></img>
            <ul>
                <li className='active'><Link to = '/'>Warehouses</Link></li>
                <li className='active'><Link to = '/products'>Products</Link></li>
                <li className='active'><Link to = '/inventory'>Inventory</Link></li>
            </ul>
        </nav>

    </>)
}

