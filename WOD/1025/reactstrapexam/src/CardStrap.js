import {Card, CardImg, CardText, CardBody, CardTitle, CardSubtitle, Button} from 'reactstrap';

function CardStrap(){
    return(
        <>
            <Card style={{width:"300px"}}>
            <CardImg style={{width:"260px", margin:"20x"}} src="duck.png" alt="duck"/>
                <CardBody>
                    <CardTitle>REACT</CardTitle>
                    <CardSubtitle>front componet</CardSubtitle>
                    <CardText>React is a front component</CardText>
                    <Button>조회</Button>
                </CardBody>
            </Card>
            <br/>

            <Card body style={{width:"300px"}} className="text-center">
                <CardTitle>카드 제목</CardTitle>
                <CardText>카드 내용입니다</CardText>
                <Button>선택</Button>
            </Card>
        </>
    )
}

export default CardStrap;