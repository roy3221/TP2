/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fernandocejas.android10.sample.test.mapper;

import com.fernandocejas.android10.sample.domain.Product;
import com.fernandocejas.android10.sample.domain.User;
import com.fernandocejas.android10.sample.presentation.mapper.UserModelDataMapper;
import com.fernandocejas.android10.sample.presentation.model.ProductModel;
import com.fernandocejas.android10.sample.presentation.model.UserModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

public class UserModelDataMapperTest extends TestCase {

  private static final int FAKE_USER_ID = 123;
  private static final String FAKE_FULLNAME = "Tony Stark";

  private UserModelDataMapper userModelDataMapper;

  @Override protected void setUp() throws Exception {
    super.setUp();
    userModelDataMapper = new UserModelDataMapper();
  }

  public void testTransformUser() {
    Product user = createFakeUser();
    ProductModel userModel = userModelDataMapper.transform(user);

    assertThat(userModel, is(instanceOf(ProductModel.class)));
    assertThat(userModel.getid(), is(FAKE_USER_ID));
//    assertThat(userModel.getFullName(), is(FAKE_FULLNAME));
  }

  public void testTransformUserCollection() {
    Product mockUserOne = mock(Product.class);
    Product mockUserTwo = mock(Product.class);

    List<Product> userList = new ArrayList<Product>(5);
    userList.add(mockUserOne);
    userList.add(mockUserTwo);

    Collection<ProductModel> userModelList = userModelDataMapper.transform(userList);

    assertThat(userModelList.toArray()[0], is(instanceOf(ProductModel.class)));
    assertThat(userModelList.toArray()[1], is(instanceOf(ProductModel.class)));
    assertThat(userModelList.size(), is(2));
  }

  private Product createFakeUser() {
    Product user = new Product(FAKE_USER_ID);
   // user.setFullName(FAKE_FULLNAME);

    return user;
  }
}
