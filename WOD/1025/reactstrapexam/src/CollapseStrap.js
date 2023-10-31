import { UncontrolledCollapse, Button, CardBody, Card} from 'reactstrap';

function CollapseStrap(){
    return(
        <>
        <Button style={{marginBottom:"10px"}} color="warning" id="toggle">펼치기/접기</Button>
        <UncontrolledCollapse toggler='#toggle'>
            <Card>
                <CardBody>
                럼피스킨병은 소에게만 감염되는 전염병으로 증상으로는 고열과 단단한 혹 같은 피부 결절이 특징이다.
                </CardBody>
            </Card>
        </UncontrolledCollapse><br/>
        <Button style={{marginBottom:"10px"}} color="warning" id="toggle">테스트버튼</Button>
        </>
    )
}

export default CollapseStrap;