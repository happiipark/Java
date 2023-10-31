import { useState } from 'react';
import { TabContent, TabPane, Nav, NavItem, NavLink, Card, Button, CardTitle, CardText, Row, Col, CardBody } from "reactstrap";
import classnames from 'classnames';

function TabStrap(){

    const [activeTab, setActiveTab] = useState('1');

    return(
        <div style={{width:"800px"}}>
            <Nav tabs>
                <NavItem>
                    <NavLink className={classnames({active:activeTab==='1'})} onClick={()=>setActiveTab('1')}>Tab1</NavLink>
                </NavItem>
                <NavItem>
                    <NavLink className={classnames({active:activeTab==='2'})} onClick={()=>setActiveTab('2')}>Tab2</NavLink>
                </NavItem>
            </Nav>
            <TabContent activeTab={activeTab}>
                <TabPane tabId={'1'}>
                    <Row>
                        <Col sm="12">
                            <h4>Tab : 1 Contents</h4>
                        </Col>
                    </Row>
                </TabPane>
                <TabPane tabId={'2'}>
                <Row>
                    <Col sm="6">
                        <Card body className="mt-2 ml-2">
                            <CardTitle>
                                Title 1
                            </CardTitle>
                            <CardText>
                                1 Contents
                            </CardText>
                            <Button>자세히</Button>
                        </Card>
                    </Col>
                    <Col sm="6">
                        <Card body className="mt-2 mr-2">
                            <CardTitle>
                                Title 2
                            </CardTitle>
                            <CardText>
                                2 Contents
                            </CardText>
                            <Button>자세히</Button>
                        </Card>
                    </Col>
                </Row>
                </TabPane>
            </TabContent>

        </div>
    )
}

export default TabStrap;