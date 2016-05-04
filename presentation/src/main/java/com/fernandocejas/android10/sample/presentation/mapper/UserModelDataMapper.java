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
package com.fernandocejas.android10.sample.presentation.mapper;

import com.fernandocejas.android10.sample.domain.Product;
import com.fernandocejas.android10.sample.domain.User;
import com.fernandocejas.android10.sample.presentation.internal.di.PerActivity;
import com.fernandocejas.android10.sample.presentation.model.ProductModel;
import com.fernandocejas.android10.sample.presentation.model.UserModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.inject.Inject;

/**
 * Mapper class used to transform {@link User} (in the domain layer) to {@link UserModel} in the
 * presentation layer.
 */
@PerActivity
public class UserModelDataMapper {

  @Inject
  public UserModelDataMapper() {}

  /**
   * Transform a {@link User} into an {@link UserModel}.
   *
   * @param user Object to be transformed.
   * @return {@link UserModel}.
   */
  public ProductModel transform(Product user) {
    if (user == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    ProductModel userModel = new ProductModel(user.getid());
    userModel.setImage_url(user.getImage_url());
    userModel.setImage_height(user.getImage_height());
    userModel.setImage_width(user.getImage_width());

    return userModel;
  }

  /**
   * Transform a Collection of {@link User} into a Collection of {@link UserModel}.
   *
   * @param usersCollection Objects to be transformed.
   * @return List of {@link UserModel}.
   */
  public Collection<ProductModel> transform(Collection<Product> usersCollection) {
    Collection<ProductModel> userModelsCollection;

    if (usersCollection != null && !usersCollection.isEmpty()) {
      userModelsCollection = new ArrayList<>();
      for (Product user : usersCollection) {
        userModelsCollection.add(transform(user));
      }
    } else {
      userModelsCollection = Collections.emptyList();
    }

    return userModelsCollection;
  }
}
