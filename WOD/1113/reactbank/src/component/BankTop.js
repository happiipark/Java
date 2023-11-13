import { useState } from "react";
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
    UncontrolledDropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem
} from 'reactstrap';
import {Link} from 'react-router-dom';

const BankTop = () => {
    const [open, setOpen] = useState(false);
    const toggle = () => {
        setOpen(!open);
    }

    return(
        <div>
            <Navbar color='light' light expand="md">
                <NavbarBrand href="https://edu.kosta.or.kr/"><b><i>kosta bank</i></b></NavbarBrand>
                <NavbarToggler onClick={toggle}/>
                <Collapse isOpen={open} navbar>
                    <Nav navbar className="ml-auto">
                        <NavItem>
                            <NavLink href="/login">로그인</NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink href="/join">회원가입</NavLink>
                        </NavItem>
                        <UncontrolledDropdown nav inNavbar>
                            <DropdownToggle nav caret>계좌</DropdownToggle>
                            <DropdownMenu right>
                                <DropdownItem>
                                    <Link to="/">계좌개설</Link>
                                </DropdownItem>
                                <DropdownItem>
                                    <Link to="/deposit">입금</Link>
                                </DropdownItem>
                                <DropdownItem>
                                    <Link to="/withdraw">출금</Link>
                                </DropdownItem>
                                <DropdownItem>
                                    <Link to="/accountInfo">계좌조회</Link>
                                </DropdownItem>
                                <DropdownItem>
                                    <Link to="/allAccountInfo">전체계좌조회</Link>
                                </DropdownItem>
                            </DropdownMenu>
                        </UncontrolledDropdown>
                    </Nav>

                </Collapse>
            </Navbar>
        </div>
    )
}

export default BankTop;