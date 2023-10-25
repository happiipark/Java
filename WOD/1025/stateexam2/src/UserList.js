import {useState} from 'react';

function UserList() {


    const [user, setUser] = useState({name:'', age:'', address:'', tel:''});
    const [userList, setUserList] = useState([]);
        
    const change = (e) => {
      let name = e.target.name;
      let value = e.target.value;
      setUser({...user, [name]:value});
    }

    const addUser = () => {
      setUserList([...userList, user]);
      setUser({name:'', age:'', address:'', tel:''});
  }

    return (
        <div className="App">
          이름 : <input type="text" name="name" value={user.name} onChange={change}/><br/>
          나이 : <input type="text" name="age" value={user.age} onChange={change}/><br/>
          주소 : <input type="text" name="address" value={user.address} onChange={change}/><br/>
          전화 : <input type="text" name="tel" value={user.tel} onChange={change}/><br/><br/>
          <button onClick={addUser}>추가</button><br/><br/>
          {userList.length>0 && <table border="1">
              <tbody>
              <tr>
                <th>이름</th><th>나이</th><th>주소</th><th>전화번호</th>
              </tr>
              
              {userList.map((item) => 
                (
                    <tr key={item.name}>
                        <td>{item.name}</td>
                        <td>{item.age}</td>
                        <td>{item.address}</td>
                        <td>{item.tel}</td>
                    </tr>
                )
              )}
              </tbody>
            </table>
        }
        </div>
      );

}

export default UserList;