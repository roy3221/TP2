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
package com.fernandocejas.android10.sample.data.net;

import com.fernandocejas.android10.sample.data.entity.ProductEntity;
import com.fernandocejas.android10.sample.data.entity.UserEntity;
import java.util.List;
import rx.Observable;

/**
 * RestApi for retrieving data from the network.
 */
public interface RestApi {
  String API_BASE_URL = "https://test.flaunt.peekabuy.com/api/look/";
  /** Api url for getting the initial outfits */
  String API_URL_GET_USER_LIST = API_BASE_URL + "create_looks_from_closet_with_anchors/";
  /** Api url for getting similar products: Remember to concatenate 'username&product_id' */
  String API_URL_GET_USER_DETAILS = API_BASE_URL + "get_similar_products/";

  /**
   * Retrieves an {@link rx.Observable} which will emit a List of {@link UserEntity}.
   */
  Observable<List<ProductEntity>> userEntityList();

  /**
   * Retrieves an {@link rx.Observable} which will emit a {@link UserEntity}.
   *
   * @param productId The user id used to get product data.
   */
  Observable<ProductEntity> userEntityById(final int productId);
}
